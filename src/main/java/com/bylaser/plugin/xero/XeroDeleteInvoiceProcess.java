package com.bylaser.plugin.xero;

import com.bas.basserver.executionengine.ExecutionException;
import com.bas.basserver.executionengine.IExecutionEngine;
import com.bas.basserver.executionengine.IProcess;
import com.bas.basserver.executionengine.SuspendProcessException;
import com.bas.connectionserver.server.AccessDeniedException;

/**
 * @author Victor
 */
public class XeroDeleteInvoiceProcess implements IProcess {
    @Override
    public Object execute(IExecutionEngine iExecutionEngine, Object[] objects) throws SuspendProcessException, ExecutionException, AccessDeniedException {
        return null;
    }

    @Override
    public Object resume(IExecutionEngine iExecutionEngine, Object o) throws SuspendProcessException, ExecutionException, AccessDeniedException {
        return null;
    }

    @Override
    public boolean cancel() {
        return false;
    }
}
