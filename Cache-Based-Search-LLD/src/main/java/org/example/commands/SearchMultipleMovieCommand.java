package org.example.commands;

import org.example.Manager.OptimalSearchManager;
import org.example.Manager.UserManager;
import org.example.Manager.searchManager;
import org.example.models.Movie;
import org.example.models.User;

public class SearchMultipleMovieCommand {
    public void executeCommand(String cmd[]){

        // SEARCH_MULTI <user_id> <genre> <year> <min_rating>
        if(cmd.length != 3) {
            throw new RuntimeException();
        }
        String userId = cmd[1];
        String genre = cmd[2];
        Long year = Long.parseLong(cmd[3]);
        Double rating = Double.parseDouble(cmd[4]);
        searchManager optimalSearchManager = new OptimalSearchManager();
        Movie searchObject = null;
        User user = UserManager.getInstance().getUser(userId);

        searchObject = new Movie(null, null, genre, year, rating);

//        optimalSearchManager.search(user, searchObject);
    }
}
