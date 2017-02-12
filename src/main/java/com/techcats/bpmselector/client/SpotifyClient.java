package com.techcats.bpmselector.client;

import com.techcats.bpmselector.config.properties.SpotifyConfiguration;
import com.wrapper.spotify.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SpotifyClient {

    @Autowired
    private SpotifyConfiguration config;

    private Api api;

    private void init() {
        api = Api.builder()
            .clientId(config.getClientid())
            .clientSecret(config.getClientsecret())
            .redirectURI(config.getRedirecturi())
            .build();
    }

    public String request() {
        if (api == null) {
            init();
        }
        List<String> scopes = Arrays.asList("user-library-read", "playlist-modify-private");
        String state = "ready";
        return api.createAuthorizeURL(scopes, state);
    }
}
