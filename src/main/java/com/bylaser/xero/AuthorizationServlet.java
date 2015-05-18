/*
 *                     AuthorizationServlet.java
 * 
 *                   Created on 20/12/2012
 * 
 ***********************************************************************
 * The software source code or any other information contained in      *
 * this file is a property of Awaresoft Pty Ltd, ACN 099 495 468.      *
 *                                                                     * 
 * This information is proprietary and confidential. Any use of        *
 * this information or part thereof, including reading, analysis,      *
 * modification, copying, combining with other software, disclosure    *
 * or distribution in any form for any purpose, is strictly prohibited *
 * unless specifically authorised by Awaresoft Pty Ltd.                *
 *                                                                     *
 * If you received a copy of this file in error please destroy the     *
 * copy immediately and notify Awaresoft Pty Ltd.                      *
 *                                                                     *
 * Copyright (c) 2002 - 2012 Awaresoft Pty Ltd. All rights reserved.    *
 ***********************************************************************
 */
package com.bylaser.xero;

import com.bas.shared.data.QueryResult;
import com.bas.shared.domain.configuration.elements.Query;
import com.bas.shared.domain.operation.IEntity;
import com.bas.webapp.common.WebAppUtils;
import org.openadaptor.util.DateTimeHolder;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class AuthorizationServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		System.out.println ("XERO Authorization servlet: doGet called");
		doPost (req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
		throws ServletException, IOException 
	{
		System.out.println ("XERO Authorization servlet: doPost called");
		
		String verifier = request.getParameter("oauth_verifier");
		if (verifier == null)
			throw new ServletException ("XERO Authorization servlet: Unable to get verifier");
		
		String token = request.getParameter("oauth_token");
		if (token == null)
			throw new ServletException ("XERO Authorization servlet:Unable to get token");
		
		String domain = request.getParameter("domain");
		if (domain == null)
			throw new ServletException ("XERO Authorization servlet:Unable to get domain");
		
		// login to the server as system guest
		ServletContext ctx = getServletContext ();
		try
		{
			HttpSession session = request.getSession();
			doIt (token, verifier, session, ctx);
			
			resp.setContentType("text/html");
			ServletOutputStream stream = resp.getOutputStream ();
			
			stream.write (BylaserConstants.getAutoClosingHTML().getBytes());
			stream.flush ();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	private void doIt (String token, String verifier, HttpSession session, ServletContext ctx)
		throws Exception
	{
		QueryResult qr = (QueryResult) WebAppUtils.sendMessageToExecutionEngine (
											ctx, 
											session, 
											"executeQuery", 
											new Object [] { Query.createFromRuleLanguageString("FIND ALL SystemSettings"), new Integer (1), new Integer (1), null, null },
											3600000);
		IEntity [] ents = qr.getEntities();
		if (ents == null)
			throw new Exception ("Unable to get SystemSettings entity");
		
		IEntity ss = ents [0];
		String cKey = (String) ss.getAttributeValue(BylaserConstants.SYSTEM_SETTINGS_XERO_CONSUMER_KEY_ATTR);
		if (cKey == null)
			throw new Exception ("XERO Authorization servlet: XERO Consumer key not defined");
		
		String cSecret = (String) ss.getAttributeValue(BylaserConstants.SYSTEM_SETTINGS_XERO_CONSUMER_SECRET_ATTR);
		if (cSecret == null)
			throw new Exception ("XERO Authorization servlet: XERO Consumer secret not defined");
		
		String baseURL = (String) ss.getAttributeValue(BylaserConstants.SYSTEM_SETTINGS_BASE_URL_ATTR);
		if (baseURL == null)
			throw new Exception ("XERO Authorization servlet: base URL not defined in SystemSettings");
				
		String tSecret = (String) ss.getAttributeValue(BylaserConstants.SYSTEM_SETTINGS_XERO_REQ_TOKEN_SECRET_ATTR);
		if (tSecret == null)
			throw new ServletException ("XERO Authorization servlet: Unable to get token secret");
		
		System.out.println ("Building service");
		OAuthService service = new ServiceBuilder().provider(XEROApi.class).apiKey(cKey).apiSecret(cSecret).callback (baseURL + "/xero.awxero").build();
		
		System.out.println ("Creating verifier");
		Verifier v = new Verifier(verifier);
		
		System.out.println ("Creating request token");
		Token requestToken = new Token (token, tSecret);
		
		System.out.println ("Getting access token");
		Token accessToken = service.getAccessToken(requestToken, v);
		
		System.out.println ("Got access token " + (accessToken == null ? "null" : accessToken.getRawResponse()));
		
		ss.setAttributeValue (BylaserConstants.SYSTEM_SETTINGS_XERO_ACC_TOKEN_ATTR, accessToken.getToken());
		ss.setAttributeValue (BylaserConstants.SYSTEM_SETTINGS_XERO_ACC_TOKEN_SECRET_ATTR, accessToken.getSecret());
		ss.setAttributeValue (BylaserConstants.SYSTEM_SETTINGS_XERO_TOKENS_TIMESTAMP_ATTR, new DateTimeHolder(new Date ()));
		
		System.out.println ("Updating System Settings");
		WebAppUtils.sendMessageToExecutionEngine (
				ctx, 
				session, 
				"updateEntity", 
				new Object [] { ss, null },
				3600000);
	}
}
