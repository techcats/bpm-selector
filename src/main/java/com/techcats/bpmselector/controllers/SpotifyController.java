package com.techcats.bpmselector.controllers;

import com.techcats.bpmselector.client.SpotifyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/spotify")
public class SpotifyController {

    @Autowired
    SpotifyClient client;

    @RequestMapping("/login")
    public String login() {
        return "redirect:" + client.request();
    }

    @RequestMapping("/accept")
    public String accept(@RequestParam(value = "code", required = true) String code) {
        //TODO
        return "redirect:/dashboard?userid=";
    }
}
