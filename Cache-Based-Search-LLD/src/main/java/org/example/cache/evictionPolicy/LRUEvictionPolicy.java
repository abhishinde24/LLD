package org.example.cache.evictionPolicy;

import org.example.doublyLinkList.DoublyLinkList;
import org.example.doublyLinkList.DoublyLinkListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K>{

    private  DoublyLinkList<K> dll;
    private  Map<K, DoublyLinkListNode<K>> nodeMap;

    public LRUEvictionPolicy(){
        this.nodeMap = new HashMap<>();
        this.dll = new DoublyLinkList<>();
    }

    @Override
    public void keyAccessed(K key){
        DoublyLinkListNode<K> node;

        if(nodeMap.containsKey(key)){
            node = nodeMap.get(key);
            dll.detachNode(node);
            dll.addNodeToLast(node);
        }else{
            node = dll.addElementToLast(key);
            nodeMap.put(key, node);
        }
    }

    @Override
    public K removeKey(){
        DoublyLinkListNode<K> firstNode = dll.getFirstNode();
        if( firstNode == null){
            return null;
        }
        dll.detachNode(firstNode);
        return firstNode.getElement();
    }
}
