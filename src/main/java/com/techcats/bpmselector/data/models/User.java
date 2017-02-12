package com.techcats.bpmselector.data.models;


public class User {

    private Long id;
    private String hashId;
    private String fitbitCode;
    private String spotifyCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getHashId() {
        return hashId;
    }

    public void setFitbitCode(String fitbitCode) {
        this.fitbitCode = fitbitCode;
    }

    public String getFitbitCode() {
        return fitbitCode;
    }

    public void setSpotifyCode(String spotifyCode) {
        this.spotifyCode = spotifyCode;
    }

    public String getSpotifyCode() {
        return spotifyCode;
    }
}
