package com.test.dsa;

public class StarPattrens {

    public static void main(String[] args) {
//        firstPattren(5);
//        secondPattern(5);
        pyramid(5);
    }

    //        *
//           * *
//          * * *
//         * * * *
    static void pyramid(int n) {
        for (int row = 1; row < n; row++) {

        }

    }

    //        * * * * *
//        * * * *
//        * * *
//        * *
//        *
    static void secondPattern(int n) {
        for (int row = n; row > 0; row--) {
            for (int col = 1; col < row; col++) {
                System.out.print("* ");
            }
            System.out.println("*");
        }
    }

    //        *
//            * *
//            * * *
//            * * * *
    // 1st Pattren
    static void firstPattren(int n) {
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < row; col++) {
                System.out.print("* ");
            }
            System.out.println("*");
        }
    }


}
