package com.continuous.practice.utils;

class JavaExtends {

    public char a() {
        System.out.println("A");
        return 0;
    }

    public static void aStatic() {
        System.out.println("a static");
    }
}

class BClass extends JavaExtends {
    public static void aStatic() {
        System.out.println("static in BClass");
    }

    public char a() {
        System.out.println("Bclass a");
        return 0;
    }

    public static void main(String[] args) {
//        JavaExtends.aStatic();
//        new BClass().a();
        JavaExtends javaExtends = new BClass();
        System.out.println(javaExtends.a());
    }
}

