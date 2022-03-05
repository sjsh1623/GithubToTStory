package com.andrew.blog.component;

import com.andrew.blog.component.ApplicationContextServe;
import com.andrew.blog.dto.Credential;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class Util {
    public JSONObject HttpTransport(String URLDestination, String input) throws Exception {
        java.net.URL url = new URL(URLDestination);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("charset", "UTF-8");
        connection.setRequestProperty("Content-Length", Integer.toString(input.getBytes().length));
        connection.setConnectTimeout(1000);

        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write("_JSON_=" + URLEncoder.encode(input, "UTF-8"));
        wr.flush();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();
        return new JSONObject(content.toString());
    }

    public Credential getCredential(String fileName) throws IOException {
        String credentialPath = getProperty("blog.local.absolutePath") + "/data/" + fileName + ".json";
        String content = new String(Files.readAllBytes(Paths.get(credentialPath)));
        JSONObject credential = new JSONObject(content);
        return new Credential(credential.getString("client_key"), credential.getString("callback_url"));
    }

    /**
     * application.properties 애서 불러오기
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
