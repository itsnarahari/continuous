package com.test.practice;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Java11FeaturesExample {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        // Single line command execute.
        System.out.println("Single line command execute java fileName.java");

        // Convert list to array.
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");

        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));

        String[] strings = new String[list.size()];
        String[] strings1 = list.toArray(strings);
        System.out.println(Arrays.toString(strings1));

        String[] strings2 = list.stream().toArray(size -> new String[list.size()]);
        System.out.println(Arrays.toString(strings2));

        String[] strings4 = list.stream().toArray(size -> new String[size]);
        System.out.println(Arrays.toString(strings4));

        String[] strings3 = list.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(strings3));

        List<Integer> list2 = List.of(4, 6, 8);
        Integer[] integers = list2.stream().toArray(Integer[]::new);

        // File Reader and Writer.
        var uri = "src/main/java/com/test/practice/fileReader.txt";
        String s = Files.readString(Path.of(uri));
        System.out.println(s);
        Files.writeString(Path.of(uri), "\nok", StandardOpenOption.APPEND);

        // String utility methods.
        System.out.println("String utility methods -------------> ");
        String str = " Narahari  ";
        System.out.println(str.isBlank());
        System.out.println(str.strip());
        System.out.println(str.stripLeading());
        System.out.println(str.stripTrailing());

        str = "dfdsf \n" +
                "dfsdfsd \n" +
                "dsfsdf \n" +
                "jghj\n";

        Stream<String> lines = str.lines();
//        lines.forEach(System.out::println);
        System.out.println(lines.count());

        // Optional
        System.out.println("Optional --------------------> ");
        Optional<String> optional = Optional.ofNullable("");
        System.out.println(optional.isEmpty());

        // http request

        System.out.println("http request ----------->");

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/todos/1"))
                .GET()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpClient httpClient = HttpClient.newBuilder()
                .build();

        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());
        System.out.println(httpResponse.headers());
        System.out.println(httpResponse.statusCode());

    }
}
