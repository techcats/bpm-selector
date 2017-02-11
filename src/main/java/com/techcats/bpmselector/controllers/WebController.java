package com.techcats.bpmselector.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/about")
    public String getIndex() {
        return "index";
    }
}
