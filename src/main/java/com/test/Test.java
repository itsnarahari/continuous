package com.test;

import java.util.HashMap;
import java.util.Map;

public class Test {
    static int[][] ladders= {{2,14},{6,18},{15,34},{19,65},{27,32},{54,88}};
    //
    static int[][] snakes = {{12,5},{21,10},{35,31},{59,42},{77,33},{98,23}};
    //
    public static void main(String[] args) {

        int[][] ladders= {{2,14},{6,18},{15,34},{19,65},{27,32},{54,88}};
//
        int[][] snakes = {{12,5},{21,10},{35,31},{59,42},{77,33},{98,23}};
//
//        3 people =
//                Dice = 3
//        1 Person = Start from => 1 => 1

        int startIndex = 1;
        int dice = 11;
        int result = 0;
        boolean flag=false;
        int tempSum = startIndex+dice;
        Map<Integer, Integer> persons= new HashMap<>();
        persons.put(1,1);
        persons.put(2,1);
        persons.put(3,1);
        int person=1;



        System.out.println(persons);
    }
    public static void getDice(int person){

        int startIndex = 1;
        int dice = 11;
        int result = 0;
        boolean flag=false;
        int tempSum = startIndex+dice;
        Map<Integer, Integer> persons= new HashMap<>();
        persons.put(1,1);
        persons.put(2,1);
        persons.put(3,1);


        for (int i = 0; i <ladders.length ; i++) {
            if(ladders[i][0]==tempSum){
                result = ladders[i][1]+tempSum;
                persons.put(person, result);
            }
        }
        for (int i = 0; i <snakes.length ; i++) {
            if(snakes[i][0]==tempSum){
                result = snakes[i][1];
                persons.put(person, result);
            }
        }

    }
}
