package com.techcats.bpmselector.client;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.techcats.bpmselector.config.properties.FitbitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Nanwarin on 2/11/17.
 */
@Service
public class FitbitClient {

    @Autowired
    private FitbitConfiguration fitbitConfiguration;

    private String authorizeCode;

    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    private GoogleAuthorizationCodeFlow flow;

    public String getAuthorURL(){
        String url = "";
        url += fitbitConfiguration.getAuthorurl();
        url += "?response_type=code&client_id=" + fitbitConfiguration.getClientID();
        url += "&redirect_uri=" + fitbitConfiguration.getRedirecturl();
        url += "&scope=heartrate%20profile&expires_in=604800";

        return url;
    }

    public void setAuthorCode(String code){
        this.authorizeCode = code;
    }

    public void getUserInfo(){

    }

}
