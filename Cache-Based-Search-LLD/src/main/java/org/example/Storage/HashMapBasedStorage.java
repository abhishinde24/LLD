package org.example.Storage;

import org.example.exceptions.NotFoundException;
import org.example.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<K,V> implements Storage<K,V> {
    private final Integer capacity;
    private final Map<K, V> storage;

    public HashMapBasedStorage(Integer capacity) {
        this.capacity = capacity;
        this.storage = new HashMap<>();
    }

    @Override
    public void put(K key, V value) throws StorageFullException{
        if (isStorageFull()) throw new StorageFullException("Storage capacity is full.");
        this.storage.put(key, value);
    }

    @Override
    public void remove(K key) throws NotFoundException{
        if (!this.storage.containsKey(key)) throw new NotFoundException("No value cached with that key.");
        this.storage.remove(key);
    }

    @Override
    public V get(K key) throws NotFoundException{
        if (!this.storage.containsKey(key)) throw new NotFoundException("No value cached with that key.");
        return this.storage.get(key);
    }

    private boolean isStorageFull() {
        return this.storage.size() == capacity;
    }
}
