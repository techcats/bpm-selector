package com.techcats.bpmselector.controllers;

import com.techcats.bpmselector.data.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        return ResponseEntity.ok(new User());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
        return ResponseEntity.ok(new User());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id")  String id) {
        return ResponseEntity.ok(new User());
    }
}
