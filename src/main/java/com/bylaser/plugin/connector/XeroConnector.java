package com.bylaser.plugin.connector;

import com.bas.basserver.executionengine.ExecutionException;
import com.bas.basserver.executionengine.IExecutionEngine;
import com.bas.basserver.executionengine.IProcess;
import com.bas.shared.domain.operation.IEntity;
import com.bylaser.plugin.util.PluginUtil;
import com.bylaser.xero.BylaserConstants;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Victor
 */
public class XeroConnector {

    private static XeroConnector instance;

    private XeroConnector() {}

    public static final XeroConnector getInstance() {
        if (instance == null) {
            instance = new XeroConnector();
        }
        return instance;
    }

    public void sendRequest(IProcess process, IExecutionEngine engine, IEntity systemSettings, Verb verb, String url,
                            String xml) throws Exception {


         String apiKey = (String) systemSettings.getAttributeValue(BylaserConstants.SYSTEM_SETTINGS_XERO_CONSUMER_KEY_ATTR);
        if (apiKey == null)
            throw new Exception ("XERO Invoice: XERO Consumer key not defined");

        String apiSecret = (String) systemSettings.getAttributeValue(BylaserConstants.SYSTEM_SETTINGS_XERO_CONSUMER_SECRET_ATTR);
        if (apiSecret == null)
            throw new Exception ("XERO Invoice: XERO Consumer secret not defined");


        String xeroAccessToken = (String) systemSettings.getAttributeValue(BylaserConstants.SYSTEM_SETTINGS_XERO_ACC_TOKEN_ATTR);
        if (xeroAccessToken == null) {
            throw new Exception("Xero Invoice: Xero Access Token not specified. Please Authorise.");
        }

        String xeroAccessTokenSecret
                = (String) systemSettings.getAttributeValue(BylaserConstants.SYSTEM_SETTINGS_XERO_ACC_TOKEN_SECRET_ATTR);
        if (xeroAccessTokenSecret == null) {
            throw new Exception("Xero Invoice: Xero Access Token Secret not specified. Please Authorise.");
        }

        OAuthService service = new ServiceBuilder().provider(XeroAPI.class).apiKey(apiKey).apiSecret(apiSecret).build();
        Token accessToken = new Token(xeroAccessToken, xeroAccessTokenSecret);

        OAuthRequest request = new OAuthRequest(verb, url);
        request.addBodyParameter("xml", xml);
        service.signRequest(accessToken, request);
        System.out.println("Sending XERO Invoice request");
        Response response = request.send();

        if (!response.isSuccessful()) {
            throw new ExecutionException(response.getBody(), -1, false);
        }

        System.out.println(response.getBody());
    }
}
