package com.continuous.practice.latest;

public class SmartPhoneDriver {

    public static void main(String[] args) {
//        SmartPhone smartPhone = new SmartPhone("Oneplus 9R","Oneplus","Oxygen Os","870",
//                "blue","48 MP");
        SmartPhone smartPhone = new SmartPhoneBuilder().setBrand("Oneplus").setOs("Oxygen").getSmartPhone();
        System.out.println(smartPhone);
    }
}
