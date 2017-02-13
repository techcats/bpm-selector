package com.techcats.bpmselector.controllers;

import com.techcats.bpmselector.data.models.User;
import com.techcats.bpmselector.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserManager userManager;

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<User> updateUser(@RequestParam("id") String id, @RequestBody User patch)
    {
        User user = userManager.findbyHashId(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        user.setAge(patch.getAge());
        user.setGender(patch.getGender());
        return ResponseEntity.ok(user);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> getUser(@PathVariable("id")  String id) {
        return ResponseEntity.ok(new User());
    }
}
