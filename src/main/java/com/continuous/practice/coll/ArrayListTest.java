package com.continuous.practice.coll;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
    static int a = 10;
    final static int b = 0;

    public static void main(String[] args) {
        a = 30;
        System.out.println(a);
        List<Integer> sList = new ArrayList<>();
        sList.add(1);
        sList.add(2);
        sList.add(3);
        sList.add(4);
        sList.add(5);
        sList.add(6);
        System.out.println(sList.size());
        for (int i = 0; i < sList.size(); i++) {
            System.out.println(i);
            sList.remove(i);
            sList.add(i);
        }

//        Iterator<Integer> iterator = sList.iterator();
//        while (iterator.hasNext()){
//            sList.remove(iterator.next());
//            sList.add(34);
//        }

        for(Integer i:sList){
            sList.remove(i);
            sList.add(34);
        }

    }
}
