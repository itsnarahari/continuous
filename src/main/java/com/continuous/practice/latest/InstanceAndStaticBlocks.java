package com.continuous.practice.latest;

import java.util.ArrayList;
import java.util.List;

public class InstanceAndStaticBlocks {

    final List<String> list;

    {
        System.out.println("Instance");
    }

    static {
        System.out.println("Static");
    }

    public InstanceAndStaticBlocks() {
        System.out.println("Constructor");
        list = new ArrayList<>();
    }

    public static void main(String[] args) {
        InstanceAndStaticBlocks instanceAndStaticBlocks = new InstanceAndStaticBlocks();
        InstanceAndStaticBlocks instanceAndStaticBlocks2 = new InstanceAndStaticBlocks();
    }

}
