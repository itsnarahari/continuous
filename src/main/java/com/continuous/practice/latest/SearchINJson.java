package com.continuous.practice.latest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SearchINJson {

    static List<JSONObject> list = new ArrayList();

    public static JSONObject restrictSalaryByDepartName(JSONObject jsonObject, String department) {
        JSONArray departments = jsonObject.getJSONArray("departments");
        JSONArray innerArray = new JSONArray();
        JSONObject rootObject = new JSONObject();
        for (int i = 0; i < departments.length(); i++) {
            JSONObject object = departments.getJSONObject(i);
            JSONArray dept = (JSONArray) object.get(department);
            JSONArray jsonArray = new JSONArray();
            for (int j = 0; j < dept.length(); j++) {
                JSONObject object1 = dept.getJSONObject(j);
                object1.remove("salary");
                jsonArray.put(object1);
            }
            object.put(department, jsonArray);
            innerArray.put(object);
        }
        rootObject.put("departments", innerArray);
        return rootObject;
    }

    public static void main(String[] args) {
        String jsonObject = "{\n" +
                "\t\"departments\": [{\n" +
                "\t\t\"ece\": [{\n" +
                "\t\t\t\"name\": \"ram\",\n" +
                "\t\t\t\"id\": 1,\n" +
                "\t\t\t\"salary\": \"1000\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name\": \"venu\",\n" +
                "\t\t\t\"id\": 2,\n" +
                "\t\t\t\"salary\": \"10000\"\n" +
                "\t\t}],\n" +
                "\t\t\"mechanical\": [{\n" +
                "\t\t\t\"name\": \"suri\",\n" +
                "\t\t\t\"id\": 3,\n" +
                "\t\t\t\"salary\": \"2000\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name\": \"sudha\",\n" +
                "\t\t\t\"id\": 4,\n" +
                "\t\t\t\"salary\": \"20000\"\n" +
                "\t\t}]\n" +
                "\t}]\n" +
                "}";

        JSONObject jsonObjects = restrictSalaryByDepartName(new JSONObject(jsonObject), "mechanical");
        System.out.println(jsonObjects);
    }
}
