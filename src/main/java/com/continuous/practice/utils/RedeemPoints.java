package com.continuous.practice.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RedeemPoints {

    // Logger
    public static Logger log = Logger.getLogger(RedeemPoints.class.getName());

    public static boolean redeemPoint(String customerId, String amount) {
        log.setLevel(Level.ALL);
        try {
            Double toRedeem = Double.valueOf(amount);
            double currentPoints = MyService.getPoints(customerId);
            double newPoints = currentPoints - toRedeem;
            MyService.save(customerId, newPoints);
            log.info(String.format("Points redeemed for customer %s", customerId));
            return true;
        } catch (Exception ex) {
            log.info(ex.toString());
            ex.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        redeemPoint("2562", "4512.25");
    }
}

class MyService {
    public static double getPoints(String customerId) {
        // Service to get points based on customer id.

        return 45.25;
    }

    public static void save(String customerId, double newPoints) {
        // Service to save the data.
    }
}
