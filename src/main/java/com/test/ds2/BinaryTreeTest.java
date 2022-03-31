package com.test.ds2;

public class BinaryTreeTest {

    static Node<Integer> head;
    public static Node createBinaryTree(){
        Node<Integer> first=new Node<>(2);
        Node<Integer> second=new Node<>(4);
        Node<Integer> third=new Node<>(7);
        Node<Integer> fourth=new Node<>(1);
        Node<Integer> fifth=new Node<>(5);
        Node<Integer> sixth=new Node<>(5);

        if(head==null){
            head=first;
        }
        first.left=second;
        second.left=third;
        first.right=fourth;
        fourth.left=fifth;
        fourth.right=sixth;
        return head;

    }
    public void inOrder(Node tree){

    }

    public static void main(String[] args) {
        System.out.println(createBinaryTree());



    }
}
