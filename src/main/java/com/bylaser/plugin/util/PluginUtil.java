package com.bylaser.plugin.util;

import com.bas.basserver.executionengine.ExecutionException;
import com.bas.basserver.executionengine.IExecutionEngine;
import com.bas.basserver.executionengine.IProcess;
import com.bas.connectionserver.server.AccessDeniedException;
import com.bas.shared.data.ObjectReference;
import com.bas.shared.domain.configuration.elements.IDomainVersion;
import com.bas.shared.domain.operation.IEntity;
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
import org.scribe.oauth.OAuthService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Victor
 */
public class PluginUtil {

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

    public static Invoice transformEntityToInvoice(IEntity entity, IExecutionEngine engine, Boolean flagEditInvoice,
                                                   IProcess iProcess)
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

        String invoiceStatus = (String) entity.getAttributeValue(Constants.I_INVOICE_STATUS);
        invoice.setStatus(InvoiceStatus.valueOf(invoiceStatus));

        String invoiceType = (String) entity.getAttributeValue(Constants.I_INVOICE_TYPE);
        invoice.setType(InvoiceType.valueOf(invoiceType));

        invoice.setReference((String) entity.getAttributeValue(Constants.I_REFERENCE));

        String contact = (String) entity.getAttributeValue(Constants.I_CONTACT);
        Contact c = new Contact();
        c.setName(contact);
        invoice.setContact(c);
        //todo: set UID (invoice number or invoiceid) only for invoices which are edited
        if (flagEditInvoice) {
            String invoiceNumber = (String) entity.getAttributeValue(Constants.I_INVOICE_NUMBER);
            invoice.setInvoiceNumber(invoiceNumber);

            Long numberId = (Long) entity.getAttributeValue(Constants.I_NUMBER_ID);
            invoice.setInvoiceID(numberId.toString());
        }

        Boolean sentToContact = (Boolean) entity.getAttributeValue(Constants.I_SENT_TO_CONTACT);
        invoice.setSentToContact(sentToContact);

        ObjectReference[] ors = entity.getReferences("invoiceLines");
        if (ors == null || ors.length == 0) {
            throw new ExecutionException ("Xero New Invoice: itemLines should not be empty", -1, false);
        }

        List<IEntity> lineItemEntities = new ArrayList<IEntity>();

        for (ObjectReference or : ors) {
            IEntity lineItem = engine.getEntity(iProcess, or.m_objectName, or.m_objectId);
            lineItemEntities.add(lineItem);
        }

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
