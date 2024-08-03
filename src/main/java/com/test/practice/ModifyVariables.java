package com.test.practice;

public class ModifyVariables {

    public static void main(String[] args) {
        System.out.println(modifyStringName("this_is_a_variable"));
        System.out.println(modifyStringName("thisIsAVariable"));
    }
    public static String modifyStringName(String input){
        String result="";
        char c[] = input.toCharArray();
        if(input.contains("_")){
            for(int i=0;i<c.length;i++) {
                if(c[i] == '_') {
                    i++;
                    char chr = Character.toUpperCase(c[i]);
                    result+=chr;
                }else {
                    result+=c[i];
                }
            }
            return result;
        }else{
            for (int i = 0; i < c.length; i++) {
                if (Character.isUpperCase(c[i])) {
                    result += "_";
                    result += c[i];
                } else
                    result += c[i];
            }
            return  result.toLowerCase();
        }
    }
}
