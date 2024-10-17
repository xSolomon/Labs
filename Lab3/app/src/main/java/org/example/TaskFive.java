package org.example;

import java.util.Map;
import java.util.stream.Collectors;

public class TaskFive {
    public static <K, V> void showTask(final Map<K, V> input) {
        System.out.println("Task 5.");
        System.out.println("Initial map:");
        System.out.println(input);
        System.out.println("After swapping:");
        System.out.println(swapKeyWithValues(input));
        System.out.println();
    }

    private static <K, V> Map<V, K> swapKeyWithValues(final Map<K, V> input) {
        return input
                .entrySet()
                .stream()
                .collect (Collectors.toMap (
                            Map.Entry::getValue,
                            Map.Entry::getKey));
    }
}
