package com.bylaser.plugin.connector;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

/**
 * @author Victor
 */
public class XeroAPI extends DefaultApi10a {
    @Override
    public String getRequestTokenEndpoint() {
        return "https://api.xero.com/oauth/RequestToken";
    }

    @Override
    public String getAccessTokenEndpoint() {
        return "https://api.xero.com/oauth/AccessToken";
    }

    @Override
    public String getAuthorizationUrl(Token token) {
        return "https://api.xero.com/oauth/RequestToken";
    }
}
