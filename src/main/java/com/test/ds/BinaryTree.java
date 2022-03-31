package com.test.ds;

public class BinaryTree {
    public static void main(String[] args) {
        Node tree=createTree();
        System.out.println("In order");
        inOrder(tree);
        System.out.println();
        System.out.println("Pre Order");
        preOrder(tree);
        System.out.println();
        System.out.println("Post Order");
        postOrder(tree);
    }

    public static Node<Integer> createTree(){
        Node<Integer> root=null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        return root;
    }
    // LNR
    static void inOrder(Node node)
    {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    // NLR
    static void preOrder(Node node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        inOrder(node.left);
        inOrder(node.right);
    }
    // LRN
    static void postOrder(Node node)
    {
        if (node == null)
            return;
        inOrder(node.left);
        inOrder(node.right);
        System.out.print(node.data + " ");
    }
}
