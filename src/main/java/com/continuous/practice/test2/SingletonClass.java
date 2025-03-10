package com.continuous.practice.test2;

public class SingletonClass {

    private static SingletonClass singletonClass = null;

    public static SingletonClass getInstance() {

        if (singletonClass == null) {
            System.out.println("Called");
            return new SingletonClass();
        }
        return singletonClass;
    }

    private SingletonClass() {
    }
}
