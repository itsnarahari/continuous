package com.test.practice;

import lombok.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    //    public static void add(int i){
//        System.out.println("ds");
//    }
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;
    String mobile;
    String email;
    String modeOfContact;

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = new String("hello");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        Integer i1 = new Integer(1);
        int i2 = 1;
        System.out.println(i1 == i2);
        System.out.println(i1.compareTo(i2));
        Map map = new HashMap();


        add(454);
    }

    public static void add(Integer i) {
        System.out.println("Integer ");
    }

    @Override
    public boolean equals(Object o) {

        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


