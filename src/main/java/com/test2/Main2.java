package com.test2;// Online Java Compiler (Editor)
// Write and run Java online using this editor.
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main2 {
    public static void main(String[] args) {
        System.out.println("Try clicking the Run button.");

        List<Item> items = List.of(
        new Item("Cake", "FMC", 100.00),
        new Item("Random", "ABC", 80.00),
        new Item("Brush", "FMC", 10.00),
        new Item("Random2", "ABC", 180.00)
    );

        Map<String,Optional<Item>> map = items.stream().collect(Collectors.groupingBy(Item::category, Collectors.maxBy(Comparator.comparing(Item::price))));

        items.stream().collect(Collectors.groupingBy(Item::category, Collectors.maxBy(Comparator.comparing(Item::price))));

        Map<String,Item> map2 = items
                .stream()
                .collect(Collectors.toMap(Item::category, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Item::price))));

        System.out.println(map2);
    }
}

record Item(String name, String category, double price){}