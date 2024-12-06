package org.example.Storage;

import org.example.exceptions.NotFoundException;
import org.example.exceptions.StorageFullException;

public interface Storage<K, V> {

    void put(K key, V value) throws StorageFullException;

    void remove(K key) throws NotFoundException;

    V get(K key) throws NotFoundException;

}