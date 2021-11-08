package com.test.boot.ds;

public class Stack {

    private int arr[];
    private int top;
    private int capacity;

    Stack(int size){
        arr = new int[size];
        top=-1;
        capacity=size;
    }
    public void push(int element){
        if(isFull()){
            System.out.println("The stack is full");
        }
        arr[++top]=element;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("The stack is full");
        }
        return arr[top--];
    }
    public boolean isFull(){
        if(arr.length==capacity){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public int peek(){
        if(!isEmpty()){
            return arr[top];
        }
        return -1;
    }
    public int size(){
        return top+1;
    }
    public boolean search(int number){
        for (int i:arr) {
            if(number==i){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(45);
        stack.push(56);
        System.out.println(stack.size());
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.size());
        System.out.println(stack.search(4543));

    }
}
