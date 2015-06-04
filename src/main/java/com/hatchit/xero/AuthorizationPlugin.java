/*
 *                     AuthorizationPlugin.java
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
package com.hatchit.xero;

import com.bas.basserver.executionengine.ExecutionException;
import com.bas.basserver.executionengine.IExecutionEngine;
import com.bas.basserver.executionengine.IProcess;
import com.bas.basserver.executionengine.SuspendProcessException;
import com.bas.connectionserver.server.AccessDeniedException;
import com.bas.shared.domain.operation.IEntity;
import com.hatchit.plugin.util.PluginUtil;

public class AuthorizationPlugin implements IProcess
{
	public Object execute(IExecutionEngine engine, Object[] parameters)
		throws SuspendProcessException, ExecutionException, AccessDeniedException 
	{
		try
		{
            IEntity ss = BylaserConstants.getAccountSettings(this, engine);
            PluginUtil.buildAuthorizationURL(this, ss, engine);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			if (e instanceof ExecutionException)
				throw (ExecutionException) e;
			if (e instanceof AccessDeniedException)
				throw (AccessDeniedException) e;
			
			throw new ExecutionException(e, 1, false);
		}
		return null;
	}

	public Object resume(IExecutionEngine engine, Object reply)
		throws SuspendProcessException, ExecutionException, AccessDeniedException 
	{
		return null;
	}

	public boolean cancel() 
	{
		return false;
	}
}
