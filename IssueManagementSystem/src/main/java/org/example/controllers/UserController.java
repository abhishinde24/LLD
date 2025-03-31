package org.example.controllers;

import java.util.HashMap;
import java.util.Map;
import org.example.models.User;

public class UserController {
    private Map<String, User> userMap;
    public UserController() {
        userMap = new HashMap<>();
    }

    public void addUser(User user){
        userMap.put(user.getEmail(), userMap.getOrDefault(user.getEmail(), user));
    }

    public User getUser(String userId) {
        if(!userMap.containsKey(userId)) return null;

        return userMap.get(userId);
    }
}
