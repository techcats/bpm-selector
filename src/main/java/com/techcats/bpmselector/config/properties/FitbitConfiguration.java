package com.techcats.bpmselector.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Nanwarin on 2/11/17.
 */

/**
 --bpmselector.thirdparty.fitbit.clientid=$FITBIT_CLIENTID_ID
 --bpmselector.thirdparty.fitbit.secretid=$FITBIT_SECREAT_ID
 --bpmselector.thirdparty.fitbit.authorurl=$FITBIT_AUTHO_URL
 --bpmselector.thirdparty.fitbit.requesturl=$FITBIT_REQUEST_URL
 --bpmselector.thirdparty.fitbit.redirectedurl=$FITBIT_REDIRECT_URL
 */

@Component
@ConfigurationProperties(prefix = "bpmselector.thirdparty.fitbit", ignoreInvalidFields = true)
public class FitbitConfiguration {

    String clientid;
    String secretid;
    String authorurl;
    String requesturl;
    String redirectedurl;

    public String getClientID(){
        return clientid;
    }

    public void setClientid(String clientID){
        this.clientid = clientID;
    }

    public String getSecretid(){
        return secretid;
    }

    public void setSecretid(String secretID){
        this.secretid = secretID;
    }

    public String getAuthorurl(){
        return authorurl;
    }

    public void setAuthorurl(String authorURL){
        this.authorurl = authorURL;
    }

    public String getRequesturl(){
        return requesturl;
    }

    public void setRequesturl(String requestURL){
        this.requesturl = requestURL;
    }

    public String getRedirecturl(){
        return redirectedurl;
    }

    public void setRedirectedurl(String redirectedURL){
        this.redirectedurl = redirectedURL;
    }
}
