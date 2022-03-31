package com.test.practice;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static boolean checkForFaulty(String str){
        boolean status=true;

        String dict[]={"help","action","work","accept"};

        for (int i = 0; i < dict.length; i++) {
            if(dict[i].equalsIgnoreCase(str)){
                status=false;
                break;
            }
        }

//        Map<Character,Integer> map = new HashMap<>();
//
//        for(int i=0;i<str.length();i++){
//            if(map.containsKey(str.charAt(i))){
//                map.put(str.charAt(i),map.get(str.charAt(i))+1);
//                status=true;
//            }
//            else{
//                map.put(str.charAt(i),1);
//            }
//        }
        return status;
    }

    public static void main(String[] args) {
        boolean status = checkForFaulty("help");
        System.out.println(status);
    }
}
