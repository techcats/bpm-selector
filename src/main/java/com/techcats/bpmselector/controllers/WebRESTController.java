package com.techcats.bpmselector.controllers;


import com.techcats.bpmselector.client.FitbitClient;
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



    //Testing
    @RequestMapping(value = "/Nanwarin")
    public String nanwarinTest(){
        return fitbitClient.getAuthorURL();
    }

    @RequestMapping(value = "/ConnectedFitbit", method = RequestMethod.GET)
    public ModelAndView connectedToFitbit(@RequestParam("code") String code){
        fitbitClient.setAuthorCode(code);
        String userId = "1";
        return new ModelAndView("redirect:/dashboard?userid=" + userId);
    }

    @RequestMapping(value = "/GrantFitbitAuthorization")
    public ResponseEntity<Object> grantFitbitAuthoraization() throws URISyntaxException{
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(new URI(fitbitClient.getAuthorURL()));

        return new ResponseEntity<Object>(httpHeaders, HttpStatus.SEE_OTHER);
    }

}
