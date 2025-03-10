package com.continuous.practice;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ToString
class Person {
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    }

    private int id;
    String name;
    public String dob;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

class Main {
    public static void main(String[] args) {

        Person person = new Person();
        List<Person> personList = new ArrayList();
        personList.add(new Person(1, "hari"));
        personList.add(new Person(1, "hari"));
        personList.add(new Person(2, "ravi"));
        System.out.println(person.name);
        System.out.println(personList);
    }
}

