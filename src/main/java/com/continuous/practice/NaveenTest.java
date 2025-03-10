package com.continuous.practice;

import java.util.*;
import java.util.stream.Collectors;

public class NaveenTest {

    public static void main(String[] args) {
//        String str="naveen";
//        String str3="naveen";
//        System.out.println(str==str3);
//        System.out.println(str.equalsIgnoreCase(str3));
//
//        str="narahari";
//        System.out.println(str);
//String st = "naveen";
//        String str="naveen";
//        str="naveenk";
//
//        System.out.println(str);
//        System.out.println(st);
////        System.out.println(str3.hashCode());
//
//        String s = "Hello, world!"; // Contains non-breaking space characters
//        System.out.println(s.strip().length());
//        System.out.println(s.trim().length());
//        m1("Str1","str2", "str3");

//        2. Method overloading
//        m1(new HashMap<>());

//        4. Streams
//        # Highest Salary
        List<Employee> employees = EmployeeDatasource.getEmployees();

//        employees.stream().map(employee -> employee.getSalary()+3000).forEach(System.out::println);
//        Predicate<Employee> predicate = e->e.getSalary()>20000;
//        employees.stream().filter(predicate).forEach(System.out::println);
//        Employee employee = employees.stream().max(Comparator.comparing(Employee::getSalary)).get();
//        Optional<Employee> min = employees.stream().min(Comparator.comparing(Employee::getSalary));
//
//        System.out.println(employee);
//        System.out.println(min.get());
//        String s = null;
//        Optional<String> optionalS = Optional.ofNullable(s);
//        if(optionalS.isPresent()){
//            System.out.println("present");
//            System.out.println(optionalS.get());
//        }

//        # Get highest and second, third salary details.
        System.out.println(getNthSalary(employees, 3));

//        # SQL Query to find Max Salary from each department.
        Map<String, Optional<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        collect.entrySet().stream().forEach(stringOptionalEntry -> {
            System.out.println(stringOptionalEntry.getKey()+"---> "+stringOptionalEntry.getValue().get().getSalary());
//            System.out.println(stringOptionalEntry.getValue().get().getSalary());
        });

        List<Employee> collect1 = employees.stream().filter(employee -> employee.getSalary() <= 15000).peek(employee -> employee.setSalary(employee.getSalary() + 5000)).collect(Collectors.toList());
        System.out.println("Transform");
        System.out.println(collect1);
    }
    public static void m1(String str){
        try{

        }catch (IllegalStateException ex){

        }catch (Exception ex){
        System.exit(1);
        }finally {
            System.out.println("final lly block should not executed");
        }
        System.out.println("String");
        System.out.println(str);
    }

    public static void m1(Object obj){
        System.out.println("Object");
        System.out.println(obj);
    }

    public static void m1(String ...str){
        Arrays.stream(Arrays.stream(str).toArray()).forEach(System.out::println);
    }

    public String toString() {
        return super.toString();
    }

    public static Employee getNthSalary(List<Employee> employees, int nth){
        if(nth> employees.size()){
            return null;
        }
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(nth).findFirst().get();
    }
}
