package com.continuous.practice.java8test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person {

    private int id;
    private String name;
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

//    @Override
//    public boolean equals(Object o) {
//        return true;
////        if (o == null || getClass() != o.getClass()) return false;
////        Person person = (Person) o;
////        return id == person.id && Objects.equals(name, person.name);
//    }

    @Override
    public int hashCode() {
        return 1;
    }
}

class PersonHandler{
    public static void main(String[] args) {
        Set<Person> personSet = new HashSet<>();
        personSet.add(new Person(2,"babu"));
        personSet.add(new Person(2,"babu"));
        personSet.add(new Person(2,"babu"));
        System.out.println(personSet.size());
    }
}
