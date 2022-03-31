package com.test.ds;

public class Node<T> {

    Node<T> left,right;
    T data;
    public Node(T data){
        this.data=data;
        left=right=null;
    }
}


