package com.test.ds2;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedListMethods linkedListMethods = new LinkedListMethods();
        linkedListMethods.add(3);
        linkedListMethods.add(5);
        linkedListMethods.add(50);
        linkedListMethods.add(46);
        System.out.println(linkedListMethods.length());
        System.out.println(linkedListMethods.getHead());
    }
}
