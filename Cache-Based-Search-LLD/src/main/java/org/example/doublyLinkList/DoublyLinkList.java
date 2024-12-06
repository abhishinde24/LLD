package org.example.doublyLinkList;

public class DoublyLinkList<E> {

    private DoublyLinkListNode<E> head;
    private DoublyLinkListNode<E> tail;

    public DoublyLinkList(){
        this.head = new DoublyLinkListNode<>(null);
        this.tail = new DoublyLinkListNode<>(null);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void detachNode(DoublyLinkListNode<E> node){

        if(node != null){
            node.prev.next = node.next;
            node.prev.prev = node.prev;
        }
    }

    public void addNodeToLast(DoublyLinkListNode<E> node){
        node.prev = this.tail.prev;
        this.tail.prev.next = node;

        node.next = this.tail;
        this.tail.prev = node;
    }

    public DoublyLinkListNode<E> addElementToLast(E key){
        DoublyLinkListNode<E> node = new DoublyLinkListNode<>(key);
        addNodeToLast(node);
        return node;
    }

    public boolean isEmpty(){
        return this.head.next == tail;
    }

    public DoublyLinkListNode<E> getFirstNode(){
        if(isEmpty()){
            return null;
        }
        return this.head.next;
    }

    public DoublyLinkListNode<E> getLastNode(){
        if(isEmpty()){
            return null;
        }
        return this.tail.prev;
    }
}
