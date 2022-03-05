package com.andrew.blog.dto;

public class Credential {
    private String secretKey;
    private String callbackURL;

    public Credential(String secretKey, String callbackURL) {
        this.secretKey = secretKey;
        this.callbackURL = callbackURL;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getCallbackURL() {
        return callbackURL;
    }
}
