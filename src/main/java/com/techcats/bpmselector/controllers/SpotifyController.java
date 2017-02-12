package com.techcats.bpmselector.controllers;

import com.techcats.bpmselector.client.SpotifyClient;
import com.techcats.bpmselector.data.models.User;
import com.techcats.bpmselector.manager.UserManager;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.models.LibraryTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

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
            String token = client.access(code);
            User user = userManager.findbyHashId(userHashId);
            user.setSpotifyToken(token);
            return "redirect:/dashboard?userid=" + user.getHashId() + "&token=" + token;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WebApiException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping("/tracks")
    public ResponseEntity<List<LibraryTrack>> getTracks(
            @RequestParam("userid") String userid,
            @RequestParam("token") String token,
            @RequestParam("limit") Integer limit,
            @RequestParam("offset") Integer offset) {
        try {
            return ResponseEntity.ok(client.getTracks(token, limit, offset));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WebApiException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body(null);
    }
}
