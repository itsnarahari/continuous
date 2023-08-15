package com.test.practice.latest;

public class SmartPhoneBuilder {

    private String name;
    private String brand;
    private String os;
    private String processor;
    private String color;
    private String camera;

    public SmartPhoneBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SmartPhoneBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public SmartPhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public SmartPhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public SmartPhoneBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public SmartPhoneBuilder setCamera(String camera) {
        this.camera = camera;
        return this;
    }

    public SmartPhone getSmartPhone() {
        return new SmartPhone(name, brand, os, processor, color, camera);
    }
}
