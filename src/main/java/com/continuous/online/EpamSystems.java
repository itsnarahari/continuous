package com.continuous.online;


public class EpamSystems<T> {

    public void m1(String i) {
        System.out.println("String is called");
        System.out.println(i);
    }

    public void m1(StringBuilder i) {
        System.out.println("StringBuilder Called");
        System.out.println(i);
    }

    public void m3(int i) {
        System.out.println("int");

    }

    public void m4(Integer i) {
        System.out.println("Integer");

    }

    static public void main(String[] args) {
        EpamSystems epamSystems = new EpamSystems();
        epamSystems.m1("null");
        epamSystems.m4(1);
    }
}

