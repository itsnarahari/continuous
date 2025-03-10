package com.continuous.practice.latest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PraveenJSONObject {

    public static void main(String[] args) throws IOException {

        String content = new String(Files.readAllBytes(Paths.get("/Applications/codebase/spring-boot-projects/continous-preparation/src/main/java/com/test/practice/latest/Out.json")));
        JSONObject res = new JSONObject(content);
        JSONArray finalArray = new JSONArray();
        if (res.has("Items")) {
            JSONArray items = res.getJSONArray("Items");
            if (items.length() > 0) {
                items.forEach(item -> {
                    JSONObject obj = (JSONObject) item;
                    obj.getJSONObject("data").put("Lat_Coord", "*****").put("Long_Coord", "*****");
                    finalArray.put(obj);
                });
            }
        }
        res.put("Items", finalArray);

        System.out.println(res);

    }
}
