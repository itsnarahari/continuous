package com.test.practice.latest;

public class DivideException {

    public static void main(String[] args) {
        System.out.println(1.0/0.0);

        Integer num1 = 100;
        Integer num2 = 100;
        if(num1==num2){
            System.out.println("num1 == num2");
        }
        else{
            System.out.println("num1 != num2");
        }
        System.out.println(0.1*3);
        System.out.println(0.1*2);
        System.out.println(0.1*3 == 0.3);
        System.out.println(0.1*2 == 0.2);

        Thread t=new Thread();
        t.stop();
    }
}
