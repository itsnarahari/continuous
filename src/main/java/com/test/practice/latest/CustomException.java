package com.test.practice.latest;

class CustomRuntimeException extends RuntimeException {
    CustomRuntimeException(String message) {
        super(message);
    }
}

public class CustomException extends Exception {
    CustomException(String message) {
        super(message);
    }
}

class MyEx {

    public void m1() {
        throw new CustomRuntimeException("ds");
    }

    public static void main(String[] args) {

    }
}
