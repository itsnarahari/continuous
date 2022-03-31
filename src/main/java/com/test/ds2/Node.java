package com.test.ds2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter
@ToString
public class Node<T> {
    T data;
    Node<T> left,right;
    Node<T> next;
    public Node(T data) {
        this.data=data;
        left=null;
        right=null;
    }
}
