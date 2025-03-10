package com.continuous.practice.latest;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

final class Singleton implements Serializable, Cloneable {
    private static Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
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

class SingletonBreaker {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, CloneNotSupportedException {
        Singleton.getInstance();
        Map map = new HashMap();
        Object put = map.put(1, 2);
        Object put2 = map.put(1, 2);
        System.out.println(put);
        System.out.println(put2);

        Singleton firstSingleton = Singleton.getInstance();
        Singleton secondSingleton = Singleton.getInstance();
        System.out.println("firstSingleton " + firstSingleton.hashCode());
        System.out.println("secondSingleton " + secondSingleton.hashCode());

        System.out.println(firstSingleton.hashCode() == secondSingleton.hashCode());

        // Break Through Reflection API
        Class<?> aClass = Class.forName("com.continuous.practice.latest.Singleton");
        Constructor<Singleton> singletonConstructor = (Constructor<Singleton>) aClass.getDeclaredConstructor();
        singletonConstructor.setAccessible(true);
        Singleton newObjByReflectionApi = singletonConstructor.newInstance();
        System.out.println("Break Through Reflection API " + newObjByReflectionApi.hashCode());

        // Through Serialization
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("sing.ser"));
        objectOutputStream.writeObject(firstSingleton);
        objectOutputStream.close();

        // Deserialization
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("sing.ser"));
        Singleton singletonInput = (Singleton) objectInputStream.readObject();
        System.out.println("Deserialization " + singletonInput.hashCode());

        // Through Cloning
        Singleton singletonWithClone = (Singleton) firstSingleton.clone();
        System.out.println("Through Cloning " + singletonWithClone.hashCode());

//
//        *How do you solve rule breakers?
//
//        It is much safer to do eager initialization
//        To prevent deserializing to create new object you may override readResolve() method in your class and throw exception
//        To prevent cloning, you may overrride clone() and throw CloneNotSupported exception
//        To escape for reflective instantion, we can add check in the constructor and throw exception.
//                Example
//
//        public class Singleton {
//
//            private static final Singleton INSTANCE = new Singleton();
//
//            private Singleton() {
//                // Check if we already have an instance
//                if (INSTANCE != null) {
//                    throw new IllegalStateException("Singleton" +
//                            " instance already created.");
//                }
//            }
//            public static final Singleton getInstance() {
//                return INSTANCE;
//            }
//            private Object readResolve() throws ObjectStreamException         {
//                return INSTANCE;
//            }
//            private Object writeReplace() throws ObjectStreamException {
//                return INSTANCE;
//            }
//            public Object clone() throws CloneNotSupportedException {
//                // return INSTANCE
//                throw new CloneNotSupportedException();
//            }
//        }

    }

}
