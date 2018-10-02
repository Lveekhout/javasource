package nl.lveekhout.jira.rest;

import com.fasterxml.jackson.jaxrs.base.ProviderBase;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * Created by eekhout.l on 02-12-2015.
 * class JerseyClientConfig
 */
public class JerseyClientConfig {
    private static ClientConfig jerseyClientConfig = null;

    public synchronized static ClientConfig getClientConfig() {
        if (jerseyClientConfig == null) {
            jerseyClientConfig = new DefaultClientConfig();
            jerseyClientConfig.getClasses().add(JacksonJsonProvider.class);
        }
        return jerseyClientConfig;
    }

}
