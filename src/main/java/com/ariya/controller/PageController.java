package com.ariya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController{
    @GetMapping("/")
    public String root() {
        return "redirect:/html/index.html";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/html/index.html";
    }

    @GetMapping("/auth")
    public String auth() {
        return "redirect:/html/auth.html";
    }

}
