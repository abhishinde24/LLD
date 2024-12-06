package org.example.cache.evictionPolicy;

public interface EvictionPolicy<K> {
    Long MAX_CACHE_SIZE = 5L;
    void keyAccessed(K key);
    K removeKey();
}
