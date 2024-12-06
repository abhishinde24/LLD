package org.example.commands;

import org.example.Manager.UserManager;
import org.example.models.User;

public class AddUserCommand implements ICommand{
    public void executeCommand(String cmd[]){
        if(cmd.length != 4){
            throw new RuntimeException();
        }
        String userId = cmd[1];
        String name = cmd[2];
        String genre = cmd[3];

        User user = new User(userId,name,genre);
        UserManager.getInstance().createUser(user);
    }
}
