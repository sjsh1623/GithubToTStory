package com.andrew.blog.component;

import com.andrew.blog.component.ApplicationContextServe;
import com.andrew.blog.dto.Credential;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.JsonObject;

@Component
public class Util {
    public Credential getCredential(String fileName) throws IOException {
        String credentialPath = getProperty("blog.local.absolutePath") + "/data/" + fileName + ".json";
        String content = new String(Files.readAllBytes(Paths.get(credentialPath)));
        JsonObject credential = JsonParser.parseString(content).getAsJsonObject();
        return new Credential(credential.get("client_key").getAsString(), credential.get("callback_url").getAsString());
    }

    /**
     * application.properties 애서 불러오기
     *
     * @param propertyName 프로퍼티명
     * @return 프로퍼티가 가지고 있는 Value
     */
    public String getProperty(String propertyName) {
        return getProperty(propertyName, null);
    }

    public String getProperty(String propertyName, String defaultValue) {
        String value = defaultValue;
        ApplicationContext applicationContext = ApplicationContextServe.getApplicationContext();
        if (applicationContext.getEnvironment().getProperty(propertyName) != null) {
            value = applicationContext.getEnvironment().getProperty(propertyName);
        }
        return value;
    }

}
