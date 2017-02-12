package com.techcats.bpmselector.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @RequestMapping("/about")
    public String getAbout() {
        return "index";
    }

    @RequestMapping("/dashboard")
    public String getDashboard() {
        return "main";
    }

    @RequestMapping("/main")
    public String getMain() {
        return "index";
    }
}
