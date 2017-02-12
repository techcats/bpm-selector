package com.techcats.bpmselector.controllers;

import com.techcats.bpmselector.client.SpotifyClient;
import com.techcats.bpmselector.data.models.User;
import com.techcats.bpmselector.manager.UserManager;
import com.wrapper.spotify.exceptions.WebApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/spotify")
public class SpotifyController {

    @Autowired
    SpotifyClient client;

    @Autowired
    UserManager userManager;

    @RequestMapping("/login")
    public String login(@RequestParam("userid") String userid) {
        return "redirect:" + client.request(userid);
    }

    @RequestMapping("/accept")
    public String accept(@RequestParam("code") String code, @RequestParam("state") String userHashId) {
        try {
            client.access(code);
            User user = userManager.findbyHashId(userHashId);
            user.setSpotifyCode(code);
            return "redirect:/dashboard?userid=" + user.getHashId();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WebApiException e) {
            e.printStackTrace();
        }
        return "index";
    }
}
