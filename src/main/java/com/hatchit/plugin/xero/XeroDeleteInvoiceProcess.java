package com.hatchit.plugin.xero;

import com.bas.basserver.executionengine.ExecutionException;
import com.bas.basserver.executionengine.IExecutionEngine;
import com.bas.basserver.executionengine.IProcess;
import com.bas.basserver.executionengine.SuspendProcessException;
import com.bas.connectionserver.server.AccessDeniedException;
import com.bas.shared.domain.operation.IEntity;
import com.connectifier.xeroclient.models.Invoice;
import org.openadaptor.dataobjects.InvalidParameterException;

import java.util.ArrayList;
import java.util.List;

import static com.hatchit.plugin.util.PluginUtil.*;

/**
 * @author Victor
 */
public class XeroDeleteInvoiceProcess implements IProcess {

    private static final String NEW_INVOICE_XERO_API_URL = "https://api.xero.com/api.xro/2.0/Invoices";

    @Override
    public Object execute(IExecutionEngine engine, Object[] objects) throws SuspendProcessException, ExecutionException, AccessDeniedException {

        if (objects == null || objects.length == 0 || !(objects[0] instanceof IEntity)) {
            throw new ExecutionException("Invalid parameters to delete invoice for Xero", -1, false);
        }

        List<Invoice> invoices = new ArrayList<>();

        try {
            for (Object param : objects) {
                IEntity invoiceEntity = (IEntity) param;
                Invoice invoice = transformEntityToInvoice(invoiceEntity, engine, true, this, true);
                invoices.add(invoice);
            }
        } catch (InvalidParameterException e) {
            throw new ExecutionException(e, -1, false);
        }
            StringBuilder invoicesBuffer = getXmlInFormatString(invoices);
            sendInvoiceToXero(invoicesBuffer, engine, this, null);

        return null;
    }

    @Override
    public Object resume(IExecutionEngine iExecutionEngine, Object o) throws SuspendProcessException, ExecutionException, AccessDeniedException {
        throw new UnsupportedOperationException("resume method not yet implemented");
    }

    @Override
    public boolean cancel() {
        throw new UnsupportedOperationException("cancel method not yet implemented");
    }
}
