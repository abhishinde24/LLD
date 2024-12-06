package org.example.Manager;

import org.example.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserManager {
    private Map<String, User> users;
    private static UserManager userManager;

    public UserManager(){
        this.users = new HashMap<>();
    }

    public static synchronized UserManager getInstance(){
        if(userManager == null){
            userManager = new UserManager();
        }
        return userManager;
    }

    public void createUser(User User){
        if(users.containsKey(User.getId())){
            throw new RuntimeException("Duplicate Id");
        }
        users.put(User.getId(),User);
    }

    public List<User> getusers(){
        return users.values().stream().collect(Collectors.toList());
    }

    public User getUser(String userId){
        if(!users.containsKey(userId)){
            throw new RuntimeException();
        }
        return users.get(userId);
    }
}
