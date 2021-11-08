package com.test.practice.test2;

interface Interface1{
    public void display();
}

interface Interface2{
    public void display();
}

public class MultipleInterfacesExtends implements Interface1,Interface2{
    @Override
    public void display() {
        System.out.println("Hai");
    }
    public <T> T foo(Class<T> clazz, Object... args) {
        return null;
    }
    public static void main(String[] args) {
        MultipleInterfacesExtends m = new MultipleInterfacesExtends();
        m.display();
    }
}
