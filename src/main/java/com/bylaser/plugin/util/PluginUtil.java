package com.bylaser.plugin.util;

import com.bas.basserver.executionengine.ExecutionException;
import com.bas.basserver.executionengine.IExecutionEngine;
import com.bas.basserver.executionengine.IProcess;
import com.bas.connectionserver.server.AccessDeniedException;
import com.bas.shared.domain.configuration.elements.IDomainVersion;
import com.bas.shared.domain.operation.IEntity;
import com.bylaser.plugin.connector.XeroConnector;
import com.bylaser.plugin.constants.Constants;
import com.bylaser.xero.BylaserConstants;
import com.bylaser.xero.XEROApi;
import com.connectifier.xeroclient.models.Contact;
import com.connectifier.xeroclient.models.CurrencyCode;
import com.connectifier.xeroclient.models.Invoice;
import com.connectifier.xeroclient.models.InvoiceStatus;
import com.connectifier.xeroclient.models.InvoiceType;
import com.connectifier.xeroclient.models.LineItem;
import org.openadaptor.dataobjects.InvalidParameterException;
import org.openadaptor.util.DateHolder;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 * @author Victor
 */
public class PluginUtil {

    private static final String INVOICE_XERO_API_URL = "https://api.xero.com/api.xro/2.0/Invoices";

    public static void buildAuthorizationURL(IProcess process, IEntity ss, IExecutionEngine engine)
            throws Exception {
        String cKey = (String) ss.getAttributeValue(BylaserConstants.SYSTEM_SETTINGS_XERO_CONSUMER_KEY_ATTR);
        if (cKey == null)
            throw new Exception("XERO Authorization plugin: XERO Consumer key not defined");

        String cSecret = (String) ss.getAttributeValue(BylaserConstants.SYSTEM_SETTINGS_XERO_CONSUMER_SECRET_ATTR);
        if (cSecret == null)
            throw new Exception("XERO Authorization plugin: XERO Consumer secret not defined");

        String baseURL = (String) ss.getAttributeValue(BylaserConstants.SYSTEM_SETTINGS_BASE_URL_ATTR);
        if (baseURL == null)
            throw new Exception("XERO Authorization plugin: base URL not defined in SystemSettings");

        IDomainVersion dv = engine.getDomainVersion(process);

        OAuthService service = new ServiceBuilder().provider(XEROApi.class).apiKey(cKey).apiSecret(cSecret).callback(baseURL + "/xero.awxero?domain=" + dv.getDomainName()).build();

        Token requestToken = service.getRequestToken();
        String authUrl = service.getAuthorizationUrl(requestToken);

        ss.setAttributeValue(BylaserConstants.SYSTEM_SETTINGS_XERO_REQ_TOKEN_SECRET_ATTR, requestToken.getSecret());
        ss.setAttributeValue(BylaserConstants.SYSTEM_SETTINGS_XERO_AUTH_URL_ATTR, authUrl);

        engine.updateEntity(process, ss);
    }

    public static void sendInvoiceToXero(StringBuilder invoicesBuffer, IExecutionEngine engine, IProcess iProcess,
                                         IEntity invoiceEntity)
            throws ExecutionException, AccessDeniedException {
            XeroConnector instance = XeroConnector.getInstance();

            try {
                //todo: implement invoices sending to Xero
                IEntity ss = BylaserConstants.getSystemSettings(iProcess, engine);
                String xml = invoicesBuffer.toString();

                   String resultXML = instance.sendRequest(iProcess, engine, ss, Verb.POST, INVOICE_XERO_API_URL, removeEmptyTags(xml));
                if (invoiceEntity != null) {
                    invoiceEntity.setAttributeValue(Constants.I_INVOICE_NUMBER, getTagValue(resultXML, "InvoiceID"));
                    engine.updateEntity(iProcess,invoiceEntity);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof ExecutionException)
                    throw (ExecutionException) e;
                if (e instanceof AccessDeniedException)
                    throw (AccessDeniedException) e;
                throw new ExecutionException(e, 1, false);
            }
    }

    private static String getTagValue(String xml, String tagName){
        return xml.split("<"+tagName+">")[1].split("</"+tagName+">")[0];
    }

    public static StringBuilder getXmlInFormatString(List<Invoice> invoices) throws ExecutionException {
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
            return invoicesBuffer;
        } catch (JAXBException e) {
            throw new ExecutionException(e, -1, false);
        }
    }

    //removes empty tags from the resulting XML
    public static String removeEmptyTags(String xml) {
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
    public static Invoice transformEntityToInvoice(IEntity entity, IExecutionEngine engine, Boolean flagEditInvoice,
                                                   IProcess iProcess, Boolean flagDeleteInvoice)
            throws InvalidParameterException, ExecutionException, AccessDeniedException {
        Invoice invoice = new Invoice();

        String currencyCode = (String) entity.getAttributeValue(Constants.I_CURRENCTY_CODE);
        CurrencyCode cc = CurrencyCode.valueOf(currencyCode);
        invoice.setCurrencyCode(cc);

        DateHolder dhDate = (DateHolder) entity.getAttributeValue(Constants.I_DATE);
        invoice.setDate(getDateFromDateHolder(dhDate));

        DateHolder dhDueDate = (DateHolder) entity.getAttributeValue(Constants.I_DUE_DATE);
        invoice.setDueDate(getDateFromDateHolder(dhDueDate));

        DateHolder dhExpPaymentDate = (DateHolder) entity.getAttributeValue(Constants.I_FULLY_PAID_ON_DATE);
        invoice.setFullyPaidOnDate(getDateFromDateHolder(dhExpPaymentDate));
        if (flagDeleteInvoice) {
            invoice.setStatus(InvoiceStatus.DELETED);
        } else {
            String invoiceStatus = (String) entity.getAttributeValue(Constants.I_INVOICE_STATUS);
            invoice.setStatus(InvoiceStatus.valueOf(invoiceStatus));
        }
        String invoiceType = (String) entity.getAttributeValue(Constants.I_INVOICE_TYPE);
        invoice.setType(InvoiceType.valueOf(invoiceType));

        invoice.setReference((String) entity.getAttributeValue(Constants.I_REFERENCE));

        String contact = (String) entity.getAttributeValue(Constants.I_CONTACT);
        Contact c = new Contact();
        c.setName(contact);
        invoice.setContact(c);

        invoice.setInvoiceNumber(entity.getAttributeValue(Constants.I_NUMBER_ID).toString());
        //todo: set UID (invoice number or invoiceid) only for invoices which are edited
        if (flagEditInvoice) {
            String numberId =  entity.getAttributeValue(Constants.I_INVOICE_NUMBER).toString();
            invoice.setInvoiceID(numberId);
        }

        Boolean sentToContact = (Boolean) entity.getAttributeValue(Constants.I_SENT_TO_CONTACT);
        invoice.setSentToContact(sentToContact);

        IEntity[] invoiceLines = engine.getAllReferences(iProcess, entity, Constants.I_INVOICE_LINES);

        List<IEntity> lineItemEntities = Arrays.asList(invoiceLines);

        if (lineItemEntities.isEmpty()) {
            throw new IllegalArgumentException("Xero Invoice: there should be at least one line iterm provided for invoice");
        }

        invoice.setLineItems(transformEntitiesToLineItems(lineItemEntities));

        return invoice;
    }

    private static List<LineItem> transformEntitiesToLineItems(List<IEntity> lineItemEntities) throws InvalidParameterException {
        List<LineItem> result = new ArrayList<>();

        for (IEntity lie : lineItemEntities) {
            LineItem lineItem = new LineItem();
            lineItem.setAccountCode((String) lie.getAttributeValue(Constants.LI_ACCOUNT_CODE));
            lineItem.setDescription((String) lie.getAttributeValue(Constants.LI_DESCRIPTION));
            Long lQuantity = (Long) lie.getAttributeValue(Constants.LI_QUANTITY);
            lineItem.setQuantity(BigDecimal.valueOf(lQuantity));
            Double lUnitAmount = (Double) lie.getAttributeValue(Constants.LI_UNIT_AMOUNT);
            lineItem.setUnitAmount(BigDecimal.valueOf(lUnitAmount));

            lineItem.setTaxType((String) lie.getAttributeValue(Constants.LI_TAX_TYPE));
            lineItem.setItemCode((String) lie.getAttributeValue(Constants.LI_ITEM_CODE));
            result.add(lineItem);
        }

        return result;
    }


    private static Date getDateFromDateHolder(DateHolder dh) {
        Date result = null;
        if (dh != null) {
            Calendar date = new GregorianCalendar();
            date.set(Calendar.YEAR, dh.getTrueYear());
            date.set(Calendar.MONTH, dh.getMonth());
            date.set(Calendar.DAY_OF_MONTH, dh.getDate());
            result = date.getTime();
        }
        return result;
    }

}
