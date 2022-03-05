package com.andrew.blog.service;

import com.andrew.blog.component.Util;
import com.andrew.blog.dto.Credential;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TstoryService {
    final Util util = new Util();

    public String getOauthURL() throws IOException {
        Credential credential = util.getCredential("TstoryCredential");
        return "https://www.tistory.com/oauth/authorize?client_id={client-id}&redirect_uri={redirect-uri}&response_type=code"
                .replace("{client-id}", credential.getSecretKey())
                .replace("{redirect-uri}", credential.getCallbackURL());
    }

}
