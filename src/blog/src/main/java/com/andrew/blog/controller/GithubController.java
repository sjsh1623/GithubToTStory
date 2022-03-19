package com.andrew.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("github")
public class GithubController {
    public String getMarkdown() {
        return "";
    }
}
