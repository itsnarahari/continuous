package com.test.practice.latest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AddDaysToTheDateString {

    static Map<String, Integer> map = new LinkedHashMap<>();

    static {
        map.put("JAN", 31);
        map.put("FEB", 28);
        map.put("MAR", 31);
        map.put("APR", 30);
        map.put("MAY", 31);
        map.put("JUN", 30);
        map.put("JUL", 31);
        map.put("AUG", 31);
        map.put("SEP", 30);
        map.put("OCT", 31);
        map.put("NOV", 30);
        map.put("DEC", 31);
    }

    // 03-FEB-2022 // 30
    public String addDays(String date, int days) {

        String[] dateArray = date.split("-");
        int addDay = Integer.parseInt(dateArray[0]) + days;
        String finalDate = "";
        if (map.containsKey(dateArray[1])) {
            if (map.get(dateArray[1]) <= addDay) {
                finalDate = addDay + "-" + dateArray[1] + "-" + dateArray[2];
            } else {
                String nxtMonth = getMonth(map.entrySet().toArray(), dateArray[1]);
                int nxtMonthDays = map.get(nxtMonth);
                if (addDay <= nxtMonthDays) {
                    finalDate = addDay + "-" + nxtMonth + "-" + dateArray[2];
                }
            }
        }

        return finalDate;
    }

    public String getMonth(Object[] list, String searchQuery) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(searchQuery)) {
                System.out.println(String.valueOf(list[i + 1]));
                return String.valueOf(list[i + 1]);
            }
        }
        return searchQuery;
    }

    public static void main(String[] args) {

        AddDaysToTheDateString addDaysToTheDateString = new AddDaysToTheDateString();
        String s = addDaysToTheDateString.addDays("03-FEB-2022", 30);
        System.out.println(s);
    }
}
