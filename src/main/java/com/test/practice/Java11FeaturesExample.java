package com.test.practice;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Java11FeaturesExample {

    public static void main(String[] args) throws IOException {

        // Single line command execute.
        System.out.println("Single line command execute java fileName.java");

        // Convert list to array.
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");

        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));

        String[] strings=new String[list.size()];
        String[] strings1 = list.toArray(strings);
        System.out.println(Arrays.toString(strings1));

        String[] strings2 = list.stream().toArray(size -> new String[list.size()]);
        System.out.println(Arrays.toString(strings2));

        String[] strings4 = list.stream().toArray(size -> new String[size]);
        System.out.println(Arrays.toString(strings4));

        String[] strings3 = list.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(strings3));

        // File Reader and Writer.
        var uri="src/main/java/com/test/practice/fileReader.txt";
        String s = Files.readString(Path.of(uri));
        System.out.println(s);
        Files.writeString(Path.of(uri),"\nok", StandardOpenOption.APPEND);

        // String utility methods.
        System.out.println("String utility methods -------------> ");
        String str=" Narahari  ";
        System.out.println(str.isBlank());
        System.out.println(str.strip());
        System.out.println(str.stripLeading());
        System.out.println(str.stripTrailing());

        str="dfdsf \n" +
                "dfsdfsd \n" +
                "dsfsdf \n" +
                "jghj\n";

        Stream<String> lines = str.lines();
//        lines.forEach(System.out::println);
        System.out.println(lines.count());

        // Optional
        System.out.println("Optional --------------------> ");
        Optional<String> optional=Optional.ofNullable(null);
    }
}
