package com.techcats.bpmselector.controllers;

import com.techcats.bpmselector.data.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        return ResponseEntity.ok(new User());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
        return ResponseEntity.ok(new User());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> getUser(@PathVariable("id")  String id) {
        return ResponseEntity.ok(new User());
    }
}
