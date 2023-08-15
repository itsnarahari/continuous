package com.test.boot;

public class Test {
    public static void main(String[] args) {
        int a[] = {30, 10, 20, -10, 20, -100};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > largest) {
                secondLargest = largest;
                largest = a[i];
            } else if (a[i] > secondLargest) {
                secondLargest = a[i];
            }
        }
        System.out.println(largest);
        System.out.println(secondLargest);
    }
}
