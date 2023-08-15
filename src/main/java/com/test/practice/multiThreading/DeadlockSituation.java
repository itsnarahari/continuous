package com.test.practice.multiThreading;

public class DeadlockSituation {

    String s1 = "s1";
    String s2 = "s2";

    public void m1() {
        synchronized (s1) {
            synchronized (s2) {
                System.out.println(s1);
                System.out.println(s2);
            }
        }
    }

    public void m2() {
        synchronized (s2) {
            synchronized (s1) {
                System.out.println(s1);
                System.out.println(s2);
            }
        }
    }

    private void overloadPrivate(int a) {
        System.out.println("overloadPrivate");
    }

    private void overloadPrivate() {
        System.out.println("overloadPrivate");
    }

    public static void main(String[] args) {
        DeadlockSituation deadlockSituation = new DeadlockSituation();
        new Thread(() -> deadlockSituation.m1()).start();
        new Thread(() -> deadlockSituation.m2()).start();
    }
}
