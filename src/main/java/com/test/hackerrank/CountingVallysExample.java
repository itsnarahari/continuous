package com.test.hackerrank;

public class CountingVallysExample {

    public static void main(String[] args) {
        System.out.println(countingValleys(8, "DDUUDDUDUUUD"));
    }

    public static int countingValleys(int steps, String path) {
        char[] pathChars = path.toCharArray();
        int lvl = 0;
        int v = 0;
        for (char c : pathChars) {
            if (c == 'U') {
                lvl++;
            }
            if (c == 'D') {
                lvl--;
            }

            if (lvl == 0 && c == 'U') {
                ++v;
            }
        }
        return v;

    }
}
