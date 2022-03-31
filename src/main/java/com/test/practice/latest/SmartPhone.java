package com.test.practice.latest;

public class SmartPhone {
    public SmartPhone(String name, String brand, String os, String processor, String color, String camera) {
        this.name = name;
        this.brand = brand;
        this.os = os;
        this.processor = processor;
        this.color = color;
        this.camera = camera;
    }

    private String name;
    private String brand;
    private String os;
    private String processor;
    private String color;
    private String camera;

    @Override
    public String toString() {
        return "SmartPhone{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", os='" + os + '\'' +
                ", processor='" + processor + '\'' +
                ", color='" + color + '\'' +
                ", camera='" + camera + '\'' +
                '}';
    }
}
