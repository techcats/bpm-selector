package com.techcats.bpmselector.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "bpmselector.thirdparty.wolframalpha", ignoreUnknownFields = true)
public class WolframAlphaConfiguration {

    private String appid;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

}
