package com.test.ds;

public class BinarySearchTree {

    public static void main(String[] args) {
        Node<Integer> root = createBST();
        inOrder(root);
    }
    public static Node<Integer> createBST(){
        int arr[]={13,16,6,10,2,4,21,18,20,3,5,17};
        int node = arr[0];
        Node<Integer> root=new Node<>(node);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<=node){
                root.left=new Node(arr[i]);
            }
            else {
                root.right = new Node(arr[i]);
            }
        }
        return root;
    }
    // LNR
    public static void inOrder(Node root){

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
}
