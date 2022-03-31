package com.test.practice.string;

public class StringTest {
    public static void main(String[] args) {

        String s1=new String("abc");
        String s2=new String("abc");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        String s3=new String("ssa");
        StringBuilder stringBuilder = new StringBuilder();

        String ana1="SILENT";
        String ana2="LISTEN";

        char[] chars = ana2.toCharArray();
        boolean flag=false;
        for (char c:chars) {
            if(!ana1.contains(String.valueOf(c))){
                flag=true;
            }
        }
        System.out.println(flag);

    }
}
