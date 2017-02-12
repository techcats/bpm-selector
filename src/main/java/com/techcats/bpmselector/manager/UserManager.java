package com.techcats.bpmselector.manager;

import com.techcats.bpmselector.data.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserManager {

    public List<User> users = new ArrayList<>(); // TEMP: Cache users for now, until user synchronization is ready

    public User findByFitBitCode(String fitbitCode) {
        for(User user : users) {
            if (fitbitCode.equals(user.getFitbitCode())) {
                return user;
            }
        }
        return null;
    }

    public User findbyHashId(String hashId) {
        for(User user : users) {
            if (hashId.equals(user.getHashId())) {
                return user;
            }
        }
        return null;
    }
}
