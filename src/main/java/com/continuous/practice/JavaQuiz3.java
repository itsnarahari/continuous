package com.continuous.practice;

public class JavaQuiz3 {
    static {
        System.out.println("Hi");
    }
    {
        System.out.println("Bye");
    }

    public static void main(String[] args) {
        int i=0;
        ++i;
        ++i;
        String s="5";
        System.out.println(i);
        System.out.println(20+5+s+4+7+1+9);
        int x=4;
        x +=x++ + ++x;
        System.out.println(x);
    }
}
