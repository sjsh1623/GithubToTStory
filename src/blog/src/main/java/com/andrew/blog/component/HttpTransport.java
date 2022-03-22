package com.andrew.blog.component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpTransport {
    private JsonObject response;

    public JsonObject getResponse() {
        return this.response;
    }

    public HttpTransport(String URLDestination, String input, String HTTPMethod) throws Exception {
        execute(URLDestination, input, HTTPMethod);
    }

    public HttpTransport(String URLDestination, String HTTPMethod) throws IOException {
        execute(URLDestination, "", HTTPMethod);
    }

    private void execute(String URLDestination, String input, String HTTPMethod) throws IOException {
        java.net.URL url = new URL(URLDestination);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(HTTPMethod);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("charset", "UTF-8");
        connection.setRequestProperty("Content-Length", Integer.toString(input.getBytes().length));
        connection.setConnectTimeout(1000);

        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write(URLEncoder.encode(input, "UTF-8"));
        wr.flush();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();
        response = JsonParser.parseString(content.toString()).getAsJsonObject();
    }
}
