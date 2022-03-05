package com.andrew.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Tstory")
public class Tstory {

   @PostMapping("/getOAuthURL")
   public String getOAuthURL () {
      return "testasdwfwaun";
   }

   @GetMapping("/callback")
   public String callback() {
      return "";
   }



}
