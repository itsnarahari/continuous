package com.continuous.practice;

public class SingletonExample {

    public static SingletonExample singletonExample = null;

    public SingletonExample(){

    }
}

class Main2{
    public static void main(String[] args) {
        SingletonExample singletonExample = new SingletonExample();
        SingletonExample singletonExample2 = new SingletonExample();

        System.out.println(singletonExample.hashCode()==singletonExample2.hashCode());
    }


}
