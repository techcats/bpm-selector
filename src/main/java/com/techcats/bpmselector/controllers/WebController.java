package com.techcats.bpmselector.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/about")
    public String getAbout() {
        return "index";
    }

    @RequestMapping("/main")
    public String getMain() {
        return "index";
    }
}
