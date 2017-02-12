package com.techcats.bpmselector.data.models;


public class User {

    private Long id;
    private String hashId;
    private String fitbitCode;
    private String spotifyToken;
    private int age;
    private String gender;
    private int restHeartRate;

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

    public void setSpotifyToken(String token) {
        this.spotifyToken = token;
    }

    public String getSpotifyToken() {
        return spotifyToken;
    }

    public int getAge(){ return age;}
    public String getGender(){return gender;}

    public int getRestHeartRate(){ return restHeartRate;};
    public void setRestHeartRate(int BPM){ this.restHeartRate = BPM;}
}
