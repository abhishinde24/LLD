package org.example.cache.evictionPolicy;

import org.example.doublyLinkList.DoublyLinkList;
import org.example.doublyLinkList.DoublyLinkListNode;

import java.util.HashMap;
import java.util.Map;

public class LFUEvictionPolicy<K> implements EvictionPolicy<K> {
    private Map<K, Integer> keyFrequencyMap;

    private Map<Integer, DoublyLinkList<K>> frequencyListMap;

    private Map<K, DoublyLinkListNode<K>> keyNodeMap;

    private int minFrequency;

    public LFUEvictionPolicy() {
        this.keyFrequencyMap = new HashMap<>();
        this.frequencyListMap = new HashMap<>();
        this.keyNodeMap = new HashMap<>();
        this.minFrequency = 0;
    }

    @Override
    public void keyAccessed(K key) {
        if (!keyFrequencyMap.containsKey(key)) {
            keyFrequencyMap.put(key, 1);
            addToFrequencyList(1, key);
            minFrequency = 1;
            return;
        }

        int currentFrequency = keyFrequencyMap.get(key);

        DoublyLinkListNode<K> node = keyNodeMap.get(key);
        DoublyLinkList<K> currentFreqList = frequencyListMap.get(currentFrequency);
        currentFreqList.detachNode(node);

        if (currentFreqList.isEmpty() && currentFrequency == minFrequency) {
            minFrequency++;
        }

        int newFrequency = currentFrequency + 1;
        keyFrequencyMap.put(key, newFrequency);

        addToFrequencyList(newFrequency, key);
    }

    @Override
    public K removeKey() {
        if (minFrequency == 0) {
            return null;
        }

        DoublyLinkList<K> minFreqList = frequencyListMap.get(minFrequency);

        DoublyLinkListNode<K> nodeToRemove = minFreqList.getFirstNode();

        K keyToRemove = nodeToRemove.getElement();
        minFreqList.detachNode(nodeToRemove);
        keyFrequencyMap.remove(keyToRemove);
        keyNodeMap.remove(keyToRemove);

        if (minFreqList.isEmpty()) {
            findNextMinFrequency();
        }

        return keyToRemove;
    }

    private void addToFrequencyList(int frequency, K key) {
        frequencyListMap.putIfAbsent(frequency, new DoublyLinkList<>());
        DoublyLinkList<K> frequencyList = frequencyListMap.get(frequency);

        DoublyLinkListNode<K> node = frequencyList.addElementToLast(key);

        keyNodeMap.put(key, node);
    }

    private void findNextMinFrequency() {
        minFrequency = Integer.MAX_VALUE;
        for (int freq : frequencyListMap.keySet()) {
            if (!frequencyListMap.get(freq).isEmpty()) {
                minFrequency = Math.min(minFrequency, freq);
            }
        }

        if (minFrequency == Integer.MAX_VALUE) {
            minFrequency = 0;
        }
    }
}