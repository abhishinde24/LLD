package org.example.doublyLinkList;

public class DoublyLinkListNode<E> {

    private E element;
    DoublyLinkListNode<E> next;
    DoublyLinkListNode<E> prev;

    public DoublyLinkListNode(E element){
        this.element = element;
        this.prev = null;
        this.next = null;
    }

    public E getElement(){
        return element;
    }

    public DoublyLinkListNode<E> getNext(){
        return next;
    }

    public DoublyLinkListNode<E> getPrev(){
        return prev;
    }

}
