package com.techcats.bpmselector.client;

import com.techcats.bpmselector.config.properties.SpotifyConfiguration;
import com.wrapper.spotify.Api;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.methods.GetMySavedTracksRequest;
import com.wrapper.spotify.models.AuthorizationCodeCredentials;
import com.wrapper.spotify.models.LibraryTrack;
import com.wrapper.spotify.models.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class SpotifyClient {

    @Autowired
    private SpotifyConfiguration config;

    private Api init() {
        return Api.builder()
            .clientId(config.getClientid())
            .clientSecret(config.getClientsecret())
            .redirectURI(config.getRedirecturi())
            .build();
    }

    public String request(String userid) {
        Api api = init();
        List<String> scopes = Arrays.asList("user-library-read", "playlist-modify-public");
        return api.createAuthorizeURL(scopes, userid);
    }

    public String access(String code) throws IOException, WebApiException {
        Api api = init();
        AuthorizationCodeCredentials authorizationCodeCredentials = api.authorizationCodeGrant(code).build().get();
        String token = authorizationCodeCredentials.getAccessToken();
        api.setAccessToken(token);
        api.setRefreshToken(authorizationCodeCredentials.getRefreshToken());
        return token;
    }

    public List<LibraryTrack> getTracks(String token, int limit, int offset) throws IOException, WebApiException {
        Api api = Api.builder().accessToken(token).build();
        GetMySavedTracksRequest request = api.getMySavedTracks()
                .limit(limit)
                .offset(offset)
                .build();
        Page<LibraryTrack> libraryTracks = request.get();
        return libraryTracks.getItems();
    }
}
