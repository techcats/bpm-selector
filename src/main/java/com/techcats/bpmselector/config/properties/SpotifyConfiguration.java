package com.techcats.bpmselector.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "bpmselector.thirdparty.spotify", ignoreUnknownFields = true)
public class SpotifyConfiguration {

    private String clientid;
    private String clientsecret;
    private String redirecturi;

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientsecret(String clientsecret) {
        this.clientsecret = clientsecret;
    }

    public String getClientsecret() {
        return clientsecret;
    }

    public void setRedirecturi(String redirecturi) {
        this.redirecturi = redirecturi;
    }

    public String getRedirecturi() {
        return redirecturi;
    }
}