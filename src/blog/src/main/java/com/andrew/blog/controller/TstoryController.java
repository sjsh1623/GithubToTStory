package com.andrew.blog.controller;

import com.andrew.blog.service.TstoryService;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
