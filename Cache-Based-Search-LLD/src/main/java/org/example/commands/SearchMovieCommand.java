package org.example.commands;

import org.example.Manager.OptimalSearchManager;
import org.example.Manager.UserManager;
import org.example.Manager.searchManager;
import org.example.models.Movie;
import org.example.models.User;

public class SearchMovieCommand implements ICommand{
    public void executeCommand(String cmd[]){

        if(cmd.length != 4) {
            throw new RuntimeException();
        }
        String userId = cmd[1];
        String parameter = cmd[2];
        String searchValue = cmd[3];
        OptimalSearchManager optimalSearchManager = new OptimalSearchManager();
        User user = UserManager.getInstance().getUser(userId);

        if(parameter.equals("TITLE")){
            optimalSearchManager.searchByTitle(user,searchValue);
        }
        else if(parameter.equals("GENRE")){
            optimalSearchManager.searchByGener(user,searchValue);
        }
        else if(parameter.equals("RELEASE")){
            optimalSearchManager.searchByRelease(user,searchValue);
        }
        else{
            System.out.println("Invalid search parameter :"+ parameter);
        }
    }
}
