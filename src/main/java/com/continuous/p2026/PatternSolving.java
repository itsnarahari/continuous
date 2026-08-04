package com.continuous.p2026;

public class PatternSolving {
    public static void main(String[] args) {
    leftSidePyramid();
    verticalPyramid();
    reversePyramid();
    }

//*
//**
//***
//****
//*****

    public static void leftSidePyramid(){
        int rows=5;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //  *
    //  **
    //  ***
    //  ****
    // *****
    public static void verticalPyramid(){
        int rows=5;
        System.out.println("Vertical Pyramid \n");
        for (int i = 1; i <=rows; i++) {
            for (int j = 1; j <= rows-i; j++) {
                System.out.print("-");
            }
            for (int k = 1; k <=i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
    public static void reversePyramid() {
        System.out.println("Reverse Pyramid");
        int rows=5;
        for (int i = rows; i >0; i--) {
            for (int k = 1; k <=rows-i ; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=i; j++) {
                System.out.print("* ");
            }
            System.out.println();

        }
    }


    }
