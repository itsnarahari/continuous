package com.continuous.practice.latest;

public class StringMessageSender {

    public static void sendMessage(String str) {

        String[] strArray = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int msgPartSize = 10;
        for (int i = 0; i < strArray.length; i++) {
            int count = strArray[i].length() + stringBuilder.length();
            if (count < msgPartSize) {
                stringBuilder.append(" " + strArray[i]);

            } else {
                System.out.print(stringBuilder);
                stringBuilder.setLength(0);
                i--;
            }
        }
    }

    public static void main(String[] args) {
        sendMessage("Hello these is Narahari from Warangal");
    }
}
