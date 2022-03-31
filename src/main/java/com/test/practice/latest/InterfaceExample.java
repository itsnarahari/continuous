package com.test.practice.latest;

import lombok.*;

import java.io.Serializable;

interface Vehicle{
    default String turnAlarmOn() {
        return "Turning the vehicle alarm on.";
    }
    static void staticEx(){
        System.out.println("Static");
    }
    default void m1(){
        System.out.println("m11111 ");
    }
}
class Car implements Vehicle{
    public String turnAlarmOn() {
        return "from class";
    }
    static void staticEx(){
        System.out.println("from Car Static");
    }
    public void m1(){
        System.out.println("m11111 ");
    }
}
@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
@ToString
class Ser implements Serializable {
    private int id;
    private transient String name;
}
public class InterfaceExample {
    public void ex(){
        Car.staticEx();
    }
    public static void main(String[] args) {
        Car car= new Car();
        car.m1();
        Vehicle vehicle = new Car();
        Vehicle.staticEx();
        System.out.println(vehicle.turnAlarmOn());

        Ser ser=new Ser(434,"fdsfds");
        System.out.println(ser.toString());
    }
}

