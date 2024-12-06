package org.example;


import org.example.Storage.Storage;
import org.example.cache.evictionPolicy.EvictionPolicy;
import org.example.exceptions.NotFoundException;
import org.example.exceptions.StorageFullException;

public class Cache<K, V> {

    private final Storage<K, V> storage;
    private final EvictionPolicy<K> evictionPolicy;

    public Cache(Storage<K, V> storage, EvictionPolicy<K> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(K key, V value) throws NotFoundException {
        try {
            this.storage.put(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException e) {
            K keyToRemove = this.evictionPolicy.removeKey();
            if (keyToRemove == null) {
                throw new RuntimeException("Unexpected state. Storage full and key is not evicting.");
            }
            this.storage.remove(keyToRemove);
            put(key, value);
        }
    }

    public V get(K key) throws NotFoundException{
        V value = null;
        try {
            value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
        } catch (NotFoundException e) {
            System.out.println("Key you are looking for, is not present in storage.");
        }

        return value;
    }

}