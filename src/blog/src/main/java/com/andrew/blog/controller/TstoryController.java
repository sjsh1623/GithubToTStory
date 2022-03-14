package com.andrew.blog.controller;

import com.andrew.blog.dto.Response;
import com.andrew.blog.service.TstoryService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Tstory")
public class TstoryController {
    final TstoryService tstoryService = new TstoryService();

    @PostMapping("/getOAuthURL")
    public String getOAuthURL() throws IOException {
        JsonObject result = new JsonObject();
        JsonObject body = new JsonObject();
        body.addProperty("url", tstoryService.getOauthURL());
        result.addProperty("code", "200");
        result.addProperty("message", "Please open this URL to continue");
        result.add("result", body);
        return result.toString();
    }

    @GetMapping("/callback")
    public String callback() {
        return "";
    }


}
