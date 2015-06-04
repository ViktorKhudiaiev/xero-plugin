package com.hatchit.plugin.xero;

import com.bas.basserver.executionengine.ExecutionException;
import com.bas.basserver.executionengine.IExecutionEngine;
import com.bas.basserver.executionengine.IProcess;
import com.bas.basserver.executionengine.SuspendProcessException;
import com.bas.connectionserver.server.AccessDeniedException;
import com.bas.shared.domain.operation.IEntity;
import com.connectifier.xeroclient.models.Invoice;
import com.hatchit.plugin.constants.Constants;
import org.openadaptor.dataobjects.InvalidParameterException;

import java.util.ArrayList;
import java.util.List;

import static com.hatchit.plugin.util.PluginUtil.*;

/**
 * @author Victor
 */
public class XeroUpdateInvoiceProcess implements IProcess {
    @Override
    public Object execute(IExecutionEngine engine, Object[] objects) throws SuspendProcessException, ExecutionException, AccessDeniedException {

        if (objects == null || objects.length == 0 || !(objects[0] instanceof IEntity)) {
            throw new ExecutionException("Invalid parameters to edit invoice for Xero", -1, false);
        }

        List<Invoice> invoices = new ArrayList<>();
        String lineAmountTypes = null;
        try {
            for (Object param : objects) {
                IEntity invoiceEntity = (IEntity) param;
                Invoice invoice = transformEntityToInvoice(invoiceEntity, engine, true, this, false);
                invoices.add(invoice);
                lineAmountTypes = (String) invoiceEntity.getAttributeValue(Constants.I_INVOICE_LINE_AMOUNT_TYPES);
            }
        } catch (InvalidParameterException e) {
            throw new ExecutionException(e, -1, false);
        }
        StringBuilder invoicesBuffer = getXmlInFormatString(invoices);
        if (lineAmountTypes != null) {
            lineAmountTypes = "<LineAmountTypes>"+ lineAmountTypes +"</LineAmountTypes>";
        }
        StringBuilder resultXML;
        if (lineAmountTypes != null) {
            resultXML = insertLineAmountTypesToXML(invoicesBuffer, lineAmountTypes);
        } else {
            resultXML = invoicesBuffer;
        }
        sendInvoiceToXero(resultXML, engine, this, null);


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
