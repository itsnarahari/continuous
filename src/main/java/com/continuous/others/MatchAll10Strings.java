package com.continuous.others;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchAll10Strings {

    public static void main(String[] args) {
        List<String> list = List.of("The patient should be informed of his therapeutic options.", "It wouldn't be as if the lone astronaut would be completely by himself.",
                "Now, a writer is entitled to have a Roget on his desk.", "Somebody should let you borrow their book", "From the earliest times until about the 1960s",
                "whether we may not, nay ought not, to use a neutral pronoun relative", "phone 9280018281", "Notionalplurality", "A starting point would be to give more support",
                "abc@gmail.com");

        List<String> regex = List.of(".*\\.$", ".*\\d{10}.*", ".*@.*", "\\w+", ".*\\s.*");
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < regex.size(); j++) {
                Pattern pattern = Pattern.compile(regex.get(j), Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(list.get(i));
                if (matcher.find()) {
                    System.out.println(String.format("%s %d %s %s %d", "String", i + 1, "matches", "regex:", j + 1));
                    break;
                }
            }
        }
    }
}
