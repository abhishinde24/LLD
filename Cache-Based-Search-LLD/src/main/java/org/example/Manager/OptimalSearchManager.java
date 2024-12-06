package org.example.Manager;

import org.example.Cache;
import org.example.Storage.HashMapBasedStorage;
import org.example.Storage.Storage;
import org.example.cache.evictionPolicy.EvictionPolicy;
import org.example.cache.evictionPolicy.LRUEvictionPolicy;
import org.example.exceptions.NotFoundException;
import org.example.models.Movie;
import org.example.models.User;

import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OptimalSearchManager implements searchManager{
    // userLevel store
    private Long capacity = 10L;
    private HashMap<String, Cache<String,List<String>>> L1UserCache;
    private Cache<String,List<String>> L2;
    private Long L1Hits;
    private Long L2Hits;

    // global store

    private void setCacheForUser(User user){
        if(!L1UserCache.containsKey(user.getId())){
            Storage storage = new HashMapBasedStorage(capacity.intValue());
            EvictionPolicy<String> evictionPolicy = new LRUEvictionPolicy<>();
            Cache userCache = new Cache(storage,evictionPolicy);
            //creating storage and hash map
            L1UserCache.put(user.getId(),userCache);
        }
    }
    @Override
    public List<Movie> search(User user,String Parameter, String searchKeys){

//        // checking in L1 chache
//        if(L1UserCache.containsKey(user.getId())){
//            try{
//               String searchValue L1UserCache.get(user.getId()).get(searchKeys);
//
//            }
//            catch(NotFoundException e){
//            }
//        }

        // if cache miss
        MovieManager movieManager = MovieManager.getInstance();
        List<Movie> movies = movieManager.getMovies();

//        List<Movie> searchResult = movies.stream().filter( list -> list.isMatch(searchKeys)).collect(Collectors.toList());

        return null;
    }

    public List<String> searchByTitle(User user, String searchKey){

        MovieManager movieManager = MovieManager.getInstance();
        List<Movie> movies = movieManager.getMovies();

        List<String> searchResult = movies.stream().filter( list -> list.getTitle().equals(searchKey)).map(Movie::getTitle).collect(Collectors.toList());

        return searchResult;
    }
    public List<String> searchByGener(User user, String searchKey){

        MovieManager movieManager = MovieManager.getInstance();
        List<Movie> movies = movieManager.getMovies();

        List<String> searchResult = movies.stream().filter( list -> list.getGenre().equals(searchKey)).map(Movie::getTitle).collect(Collectors.toList());

        for(String it : searchResult){
            System.out.println("Titles "+it);
        }
        return searchResult;
    }
    public List<String> searchByRelease(User user, String searchKey){

        MovieManager movieManager = MovieManager.getInstance();
        List<Movie> movies = movieManager.getMovies();
        Long year = Long.parseLong(searchKey);
        List<String> searchResult = movies.stream().filter( list -> list.getYear().equals(year)).map(Movie::getTitle).collect(Collectors.toList());

        return searchResult;
    }
}
