package com.test.practice.latest;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.Set;

class Singleton implements Serializable,Cloneable {
    private static Singleton singleton=null;

    private Singleton(){
    }
    public static Singleton getInstance(){
        if(singleton==null){
            synchronized (singleton){
                singleton = new Singleton();
            }
        }
        return singleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class SingletonBreaker{

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, CloneNotSupportedException {

        LinkedHashSet set = new LinkedHashSet();
        set.add("fds");
        Singleton firstSingleton = Singleton.getInstance();
        Singleton secondSingleton = Singleton.getInstance();
        System.out.println("firstSingleton "+ firstSingleton.hashCode());
        System.out.println("secondSingleton "+ secondSingleton.hashCode());

        // Break Through Reflection API
        Class<?> aClass = Class.forName("com.test.practice.latest.Singleton");
        Constructor<Singleton> singletonConstructor = (Constructor<Singleton>) aClass.getDeclaredConstructor();
        singletonConstructor.setAccessible(true);
        Singleton newObjByReflectionApi = singletonConstructor.newInstance();
        System.out.println("Break Through Reflection API "+ newObjByReflectionApi.hashCode());

        // Through Serialization
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("sing.ser"));
        objectOutputStream.writeObject(firstSingleton);
        objectOutputStream.close();

        // Deserialization
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("sing.ser"));
        Singleton singletonInput = (Singleton) objectInputStream.readObject();
        System.out.println("Deserialization "+ singletonInput.hashCode());

        // Through Cloning
        Singleton singletonWithClone = (Singleton) firstSingleton.clone();
        System.out.println("Through Cloning "+ singletonWithClone.hashCode());

    }

}
