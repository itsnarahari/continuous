package com.test.practice.test2;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OuterClass {

    private String name;

    class InnerClass {
        public void display() {
            int id = 10;
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        InnerClass ic = new OuterClass().new InnerClass();
        ic.display();
    }
}
