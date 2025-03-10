package com.continuous.practice.latest;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node<T> {
    private T data;
    private Node<T> nextNode;

    public Node(T data) {
        this.data = data;
    }
}
