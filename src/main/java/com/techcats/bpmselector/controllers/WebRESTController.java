package com.techcats.bpmselector.controllers;


import com.techcats.bpmselector.client.FitbitClient;
import com.techcats.bpmselector.data.models.User;
import com.techcats.bpmselector.manager.UserManager;
import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Nanwarin on 2/11/17.
 */
@RestController
public class WebRESTController {

    @Autowired
    FitbitClient fitbitClient;

    @Autowired
    UserManager userManager;

    //Testing
    @RequestMapping(value = "/Nanwarin")
    public String nanwarinTest(){
        return fitbitClient.getAuthorURL();
    }

    @RequestMapping(value = "/ConnectedFitbit", method = RequestMethod.GET)
    public ModelAndView connectedToFitbit(@RequestParam("code") String code){
        fitbitClient.setAuthorCode(code);
        User user = userManager.findByFitBitCode(code);
        if (user == null) {
            // TEMP: cache users instead of save into database
            user = new User();
            user.setId((long) userManager.users.size());
            user.setHashId(new Hashids().encode(user.getId()));
            userManager.users.add(user);
        }
        return new ModelAndView("redirect:/dashboard?userid=" + user.getHashId());
    }

    @RequestMapping(value = "/GrantFitbitAuthorization")
    public ResponseEntity<Object> grantFitbitAuthoraization() throws URISyntaxException{
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(new URI(fitbitClient.getAuthorURL()));

        return new ResponseEntity<Object>(httpHeaders, HttpStatus.SEE_OTHER);
    }

}
