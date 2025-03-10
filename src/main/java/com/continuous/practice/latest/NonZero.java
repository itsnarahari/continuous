package com.continuous.practice.latest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class NonZero {

    JdbcTemplate jdbcTemplate;

    final static int NO_OF_CHARS = 256;
    public void m1(){
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        String query = "select image from images where id in(?)";
//        List<Integer> ids= List.of(1,2,3,4);
//        String inSql = String.join(",", ids);
//        System.out.println(inSql);
        List<Integer> list = Arrays.asList(1,2);
        String numberString = list.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(numberString);
        String replacedQuery = query.replace("?", numberString);
        System.out.println(replacedQuery);
//
//        jdbcTemplate.query("dfsd", new RowMapper<Object>() {
//        })
    }

    @Override
    public String toString() {
        return "dsfs";
    }

    public static int[] zerosToEnd(int arr[]) {
        System.out.println("zerosToEnd");
        System.out.println(Arrays.toString(arr));
        int count = 0;  // Count of non-zero elements
        int n = arr.length;
        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i]; // here count is
//        System.out.println("countcount " + count);
        while (count < n)
            arr[count++] = 0;
        return arr;
    }

    public static int[] zerosToFirst(int array[]) {
        System.out.println(Arrays.toString(array));
        int count = array.length - 1;
        for (int i = array.length; i > 0; i--) {
            if (array[i] != 0) {
                array[count--] = array[i];
            }
        }
        while (count > 0) {
            array[count--] = 0;
        }
        return array;
    }

    public static void main(String[] args) throws FileNotFoundException {
        NonZero nonZero=new NonZero();
        nonZero.m1();
        List<Integer> integers = List.of(3, 0, 3, 0, 8, 9, 0, 7, 9);
        System.out.println("Move zeros to first in array");
        System.out.println(Arrays.toString(zerosToFirst(new int[]{3, 0, 2, 4, 8, 9, 0, 0, 9, 56, 0, 3, 0})));
        System.out.println("Move zeros to end of array ");
        System.out.println(Arrays.toString(zerosToEnd(new int[]{3, 0, 2, 4, 8, 9, 0, 0, 9, 56, 0, 3, 0})));
    }
}
