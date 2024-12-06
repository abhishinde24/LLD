package org.example.Manager;

import org.example.models.Movie;
import org.example.models.User;

import java.util.List;
import java.util.Map;

public interface searchManager {
    List<Movie> search(User user, String parameter, String value);
}
