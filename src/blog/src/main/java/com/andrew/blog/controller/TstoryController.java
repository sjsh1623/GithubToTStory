package com.andrew.blog.controller;

import com.andrew.blog.dto.Response;
import com.andrew.blog.service.TstoryService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("Tstory")
public class TstoryController {
   final TstoryService tstoryService = new TstoryService();

   @ResponseBody
   @PostMapping("/getOAuthURL")
   public Response getOAuthURL () throws IOException {
      Response response = new Response();

      JSONObject body = new JSONObject();
      body.put("URL", tstoryService.getOauthURL());

      response.setBody(body.toString());
      System.out.println(body.toString());
      response.setMessage("Please open this URL to continue");
      return response;
   }

   @GetMapping("/callback")
   public String callback() {
      return "";
   }



}
