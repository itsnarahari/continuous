package com.test.practice;

public class POJO {
    
    private int id;
    private static String name;
    private static final int age = 0;
    
    public POJO(int id, String name, int age){
        this.id=id;
    }
    public void babu(){
        name="sdas";
        String b = "dfsd";
        name="dfsd";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        POJO.name = name;
    }
}
class A{
    public String str;
    private void m1(){

    }
}
class B extends A{
    private int age;
    public B(int age, String str){
        super.str=str;
        this.age=age;
    }
}
