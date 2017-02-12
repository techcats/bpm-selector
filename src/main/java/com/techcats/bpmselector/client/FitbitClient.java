package com.techcats.bpmselector.client;

import com.google.api.client.auth.oauth2.*;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.techcats.bpmselector.config.properties.FitbitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;

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
    private static final Collection<String> SCOPES = Arrays.asList("heartrate%20profile".split("%20"));
    private static final String URL_USER_INFO = "https://api.fitbit.com/1/user/-/profile.json";

    //private GoogleAuthorizationCodeFlow flow;
    private AuthorizationCodeFlow flow;

    public String getAuthorURL(){
        String url = "";
        url += fitbitConfiguration.getAuthorurl();
        url += "?response_type=code&client_id=" + fitbitConfiguration.getClientID();
        url += "&redirect_uri=" + fitbitConfiguration.getRedirecturl();
        url += "&scope=heartrate%20profile&expires_in=604800";

        return url;
    }

    public void setAuthorCode(String code) throws IOException{
        this.authorizeCode = code;
        byte[] valueDecodeed = Base64.getDecoder().decode(code);
        System.out.println("Decoded value is " + new String(valueDecodeed));


    }

    public void getUserInfo() throws IOException{
        final GenericUrl tokenURL = new GenericUrl(fitbitConfiguration.getRequesturl());


        flow = new AuthorizationCodeFlow.Builder(BearerToken.authorizationHeaderAccessMethod(),
                HTTP_TRANSPORT, JSON_FACTORY,
                tokenURL,
                new ClientParametersAuthentication(fitbitConfiguration.getClientID(), fitbitConfiguration.getSecretid()),
                fitbitConfiguration.getClientID(),
                fitbitConfiguration.getAuthorurl()
                 ).build();



        final TokenResponse response = flow.newTokenRequest(fitbitConfiguration.getAuthorurl()).setRedirectUri(fitbitConfiguration.getRequesturl()).execute();
        final Credential credential = flow.createAndStoreCredential(response, null);
        final HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(credential);
        // Make an authenticated request
        final GenericUrl url = new GenericUrl(URL_USER_INFO);
        final HttpRequest request = requestFactory.buildGetRequest(url);
        request.getHeaders().setContentType("application/json");
        final String jsonIdentity = request.execute().parseAsString();

    }


    public static void test(){

    }

}
