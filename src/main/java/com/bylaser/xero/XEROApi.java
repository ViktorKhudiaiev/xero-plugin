/*
 *                     XEROApi.java
 * 
 *                   Created on 19/12/2012
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

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

public class XEROApi extends DefaultApi10a 
{
	public String getAccessTokenEndpoint() 
	{
		return "https://api.xero.com/oauth/AccessToken";
	}

	public String getAuthorizationUrl(Token requestToken) 
	{
	   return "https://api.xero.com/oauth/Authorize?oauth_token=" + requestToken.getToken();
	}

	public String getRequestTokenEndpoint() 
	{
		return "https://api.xero.com/oauth/RequestToken";
	}
}
