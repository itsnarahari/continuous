package com.test.practice;

import java.util.Arrays;
import java.util.Random;

public class StudentReports {

    public static void main(String[] args) {
//        System.out.println(sortStudentMarks(3));
        Thread thread=new Thread();
        Random random=new Random();
        random.longs().limit(15).sorted().forEach(System.out::println);
        int[][] multi = {
                { 75 ,76 ,65 ,87,87 },
                { 78 ,76, 68, 56, 89 },
                { 67, 87, 78, 77, 65 }
        };
        int[] ints = sortStudentMarks(3, 5, multi);
        System.out.println(Arrays.toString(ints));

        int[][] multi2 = {
                { 50, 30, 70 },
                { 30, 70, 99 },
                { 99, 20, 30 }
        };
        int[] ints2 = sortStudentMarks(3,3, multi2);
        System.out.println(Arrays.toString(ints2));
    }
    public static int[] sortStudentMarks(int input1, int input2, int[][] input3) {
        int students = input1;
        int subjects  = input2;
        int marks[][] = input3;

        int avg[] = new int[subjects];
        int min = -1;
        int skipIndex = -1;

        for (int sub = 0; sub < subjects; sub++) {
            for (int stu = 0; stu < students; stu++) {
                avg[sub] += marks[stu][sub];
            }
            avg[sub] /= students;
            if (sub == 0) {
                min = avg[0];
                skipIndex = 0;
            } else if (avg[sub] < min) {
                min = avg[sub];
                skipIndex = sub;
            }
        }
        int result[] = new int[students];
        for (int row = 0; row < students; row++) {
            for (int col = 0; col < subjects; col++) {
                if (skipIndex != col)
                    result[row] += marks[row][col];
            }
        }
        return result;
    }
}
