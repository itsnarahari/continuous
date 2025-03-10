package com.continuous.practice.latest;

public class SimpleRandomNumber {

    private int last;
    private int max;

    public SimpleRandomNumber(int max) {
        this.max = max;
        last = (int) (System.currentTimeMillis() % max);
    }

    public int nextInt() {
        System.out.println(last);
        last = (last * 32719 + 3) % 32749;
        return last % max;
    }

    public static void main(String[] args) {
        SimpleRandomNumber rand = new SimpleRandomNumber(5);

        for (int i = 0; i < 25; i++) {
            System.out.println(rand.nextInt());
        }

    }
}
