package com.test.online;




public class EpamSystems<T> {

    public static void m1(String i){
        System.out.println(i);
    }
    public static void m1(StringBuilder i){
        System.out.println(i);
    }
    private T t;
    static EpamSystems epamSystems;
    public void set(T t){
        this.t=t;
    }
    public T get(){
        return t;
    }
     static public void main(String[] args) {
        EpamSystems epamSystems = new EpamSystems();
        epamSystems.set("sds");
        epamSystems.set("%");
        System.out.println(epamSystems.get());
        EpamSystems.m1("null");

    }
}

