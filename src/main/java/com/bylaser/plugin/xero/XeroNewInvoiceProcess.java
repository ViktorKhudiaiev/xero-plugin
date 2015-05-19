package com.bylaser.plugin.xero;

import com.bas.basserver.executionengine.ExecutionException;
import com.bas.basserver.executionengine.IExecutionEngine;
import com.bas.basserver.executionengine.IProcess;
import com.bas.basserver.executionengine.SuspendProcessException;
import com.bas.connectionserver.server.AccessDeniedException;
import com.bas.shared.domain.operation.IEntity;
import com.bylaser.plugin.connector.XeroConnector;
import com.bylaser.xero.BylaserConstants;
import com.connectifier.xeroclient.models.Invoice;
import org.openadaptor.dataobjects.InvalidParameterException;
import org.scribe.model.Verb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import static com.bylaser.plugin.util.PluginUtil.*;

/**
 * @author Victor
 */
public class XeroNewInvoiceProcess implements IProcess {

    private static final String NEW_INVOICE_XERO_API_URL = "https://api.xero.com/api.xro/2.0/Invoices";

    @Override
    public Object execute(IExecutionEngine engine, Object[] objects) throws SuspendProcessException, ExecutionException, AccessDeniedException {

        if (objects == null || objects.length == 0 || !(objects[0] instanceof IEntity)) {
            throw new ExecutionException("Invalid parameters to create invoice for Xero", -1, false);
        }

        List<Invoice> invoices = new ArrayList<>();

        try {
            for (Object param : objects) {
                IEntity invoiceEntity = (IEntity) param;
                Invoice invoice = transformEntityToInvoice(invoiceEntity, engine, false, this);
                invoices.add(invoice);
            }
        } catch (InvalidParameterException e) {
            throw new ExecutionException(e, -1, false);
        }
        StringBuilder invoicesBuffer = getXmlInFormatString(invoices);
        sendInvoiceToXero(invoicesBuffer, engine, this);
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
