package com.andrew.blog.controller;

import com.andrew.blog.service.GithubService;
import com.andrew.blog.service.TstoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("github")
public class GithubController {
    final GithubService githubService = new GithubService();

    @GetMapping("/getMarkdown")
    public String getMarkdown() throws Exception {
        githubService.getGuthubData("sjsh1623", "Book");
        return "";
    }
}
