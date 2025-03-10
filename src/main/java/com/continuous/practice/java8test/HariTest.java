package com.continuous.practice.java8test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class HariTest {

    public static void main(String[] args) throws JsonProcessingException {
        String str = " [\n" +
                "{\n" +
                "\"order_Id\": \"1\",\n" +
                "\"item_id\": \"22\",\n" +
                "\"user_id\": \"223\"\n" +
                "},\n" +
                "{\n" +
                "\"order_Id\": \"2\",\n" +
                "\"item_id\": \"22\",\n" +
                "\"user_id\": \"223\"\n" +
                "},\n" +
                "{\n" +
                "\"order_Id\": \"2\",\n" +
                "\"item_id\": \"24\",\n" +
                "\"user_id\": \"223\"\n" +
                "},\n" +
                "{\n" +
                "\"order_Id\": \"2\",\n" +
                "\"item_id\": \"26\",\n" +
                "\"user_id\": \"223\"\n" +
                "},\n" +
                "{\n" +
                "\"order_Id\": \"3\",\n" +
                "\"item_id\": \"22\",\n" +
                "\"user_id\": \"233\"\n" +
                "},\n" +
                "{\n" +
                "\"order_Id\": \"3\",\n" +
                "\"item_id\": \"26\",\n" +
                "\"user_id\": \"233\"\n" +
                "}\n" +
                "]";

        List<Map<String, Object>> mapList = new ObjectMapper().readValue(str, List.class);
        System.out.println(mapList);


        JSONArray jsonArray = new JSONArray(str);
//        System.out.println(jsonArray);
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            if (map.containsKey(jsonObject.get("user_id"))) {
                map.put((String) jsonObject.get("user_id"), map.get(jsonObject.get("user_id")).concat(jsonObject.getString("order_Id")));
            } else {
                map.put(String.valueOf(jsonObject.get("user_id")), jsonObject.getString("order_Id"));
            }
        }
        System.out.println(map);
    }
}
