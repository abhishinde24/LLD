package org.example.Manager;

import org.example.Cache;
import org.example.Storage.HashMapBasedStorage;
import org.example.Storage.Storage;
import org.example.cache.evictionPolicy.EvictionPolicy;
import org.example.cache.evictionPolicy.LRUEvictionPolicy;

import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;

public class CacheManager {
    private static CacheManager cacheManager;
    private HashMap<String,Cache<String,String>> L1UserCache;
    private Cache<String,String> L2;
    private Long L1CacheHits = 0L;
    private Long L2CacheHist = 0L;

    public CacheManager(int capacity){
        L1UserCache = new HashMap<>();

        //creating storage and hash map
        Storage storage = new HashMapBasedStorage(capacity);
        EvictionPolicy<String> evictionPolicy = new LRUEvictionPolicy<>();
        L2 = new Cache(storage,evictionPolicy);
    }

    public static synchronized CacheManager getInstance(){
        if(cacheManager == null){
            cacheManager = new CacheManager(4);
        }
        return cacheManager;
    }
}
