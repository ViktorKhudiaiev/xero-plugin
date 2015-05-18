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
import java.util.Scanner;

import static com.bylaser.plugin.util.PluginUtil.transformEntityToInvoice;

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

        try {
            StringBuilder invoicesBuffer = new StringBuilder();
            invoicesBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n");
            invoicesBuffer.append("<Invoices>\n");

            JAXBContext jaxbContext = JAXBContext.newInstance(Invoice.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            QName qName = new QName("Invoice");

            for (Invoice invoice : invoices) {
                JAXBElement<Invoice> root = new JAXBElement<>(qName, Invoice.class, invoice);
                StringWriter sw = new StringWriter();
                marshaller.marshal(root, sw);

                String s = sw.toString();
                //trim first line in order to have valid XML
                s = s.substring(s.indexOf(System.getProperty("line.separator")) + 1);
                invoicesBuffer.append(s).append("\n");
            }
            invoicesBuffer.append("</Invoices>");

            XeroConnector instance = XeroConnector.getInstance();

            try {
                //todo: implement invoices sending to Xero
                IEntity ss = BylaserConstants.getSystemSettings(this, engine);
                String xml = invoicesBuffer.toString();

                instance.sendRequest(this, engine, ss, Verb.POST, NEW_INVOICE_XERO_API_URL, removeEmptyTags(xml));
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof ExecutionException)
                    throw (ExecutionException) e;
                if (e instanceof AccessDeniedException)
                    throw (AccessDeniedException) e;

                throw new ExecutionException(e, 1, false);
            }

        } catch (JAXBException e) {
            throw new ExecutionException(e, -1, false);
        }


        return null;
    }

    //removes empty tags from the resulting XML
    private String removeEmptyTags(String xml) {
        StringBuilder result = new StringBuilder();
        Scanner scanner = new Scanner(xml);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.endsWith("/>")) {
                result.append(line).append("\n");
            }
        }
        return result.toString();
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
