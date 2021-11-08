package com.test.practice.test2;

public class StarOne {

    public static void buildPyramid(int len){
        for(int i=0;i<len;i++){
            for(int j=len-i;j>1;j--){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void reversePyramid(int len) {
        for (int i = 0; i <len; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= len -i; k++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
//        buildPyramid(5);
        reversePyramid(5);
    }
}
