package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TaskFour {
    public static void showTask(final String text) {
        System.out.println("Task 4.");
        System.out.println(makeFrequencyDict(text));
        System.out.println();
    }

    private static HashMap<String, Long> makeFrequencyDict(final String text) {
        return Arrays.stream(text.split(" "))
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(
                                Function.identity(),
                                HashMap::new,
                                Collectors.counting()));
    }
}
