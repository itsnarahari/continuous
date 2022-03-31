package com.test.ds2;

import lombok.ToString;

@ToString
public class LinkedListMethods<T> {
    Node<T> head;
    public void add(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next=null;
        if(head==null){
            this.head=newNode;
        }
        this.head.next=newNode;
    }
    public int length(){
        Node current=this.head;
        int counter=0;
        while (current!=null){
            counter++;
            current=current.getNext();
        }
        return counter;
    }

    public Node<T> getHead() {
        return head;
    }
}
