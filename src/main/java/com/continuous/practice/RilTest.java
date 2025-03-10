package com.continuous.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RilTest {

    public static void main(String[] args) {
        StringBuilder stringObj=new StringBuilder("hi");
        String literal="hi";
        System.out.println(literal.intern());
        System.out.println(stringObj.toString().equals(literal));

        List<Integer> list = new ArrayList<>(10);
        list=new ArrayList<>(40);
        String str="";
        System.out.println(String.valueOf(str));
        str.toString();


        //  arraylist with 5 objects where each objects are employee object
        // name, age

        List<Employee> sortedEmployees = getSortedEmployees(EmployeeDatasource.getEmployees());
        System.out.println(sortedEmployees);
        RilTest rilTest = new RilTest();
        rilTest.m1(null);

        System.out.println(12/10);
        System.out.println(13%10);

    }
    public void m1(Object object){
        System.out.println("Object");
    }
    public void m1(String string){
        System.out.println("string");
    }

    public static List<Employee> getSortedEmployees(List<Employee> employees) {
        try {
            if (employees.size() > 0) {
                List<Employee> sortedEmployees = employees.stream()
                        .sorted(Comparator.comparing(Employee::getAge))
                        .collect(Collectors.toList());
                return sortedEmployees;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ArrayList<>();
    }
}
