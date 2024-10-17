package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TaskOne {
    public static void showTask(final int N) {
        System.out.println("Task 1.");
        // a)
        System.out.println("Array of random numbers.");
        final Integer[] randomNumbers = new Integer[N];
        final Random randomIntGenerator = new Random();
        for(int i = 0; i < N; ++i) {
            randomNumbers[i] = randomIntGenerator.nextInt(101);
        }
        System.out.print(Arrays.toString(randomNumbers));
        System.out.println();

        // b)
        System.out.println("List from array.");
        final List<Integer> randomList = new ArrayList<>();
        Collections.addAll(randomList, randomNumbers);
        System.out.println(randomList);
        System.out.println();

        // c)
        System.out.println("Sorted list.");
        Collections.sort(randomList);
        System.out.println(randomList);
        System.out.println();

        // d)
        System.out.println("Reversed list.");
        Collections.reverse(randomList);
        System.out.println(randomList);
        System.out.println();

        // e)
        System.out.println("Shuffled list.");
        Collections.shuffle(randomList);
        System.out.println(randomList);
        System.out.println();

        // f)
        System.out.println("Rotated list.");
        Collections.rotate(randomList, 1);
        System.out.println(randomList);
        System.out.println();

        final HashMap<Integer, Integer> valuesFrequency =
            new HashMap<Integer, Integer>(
                randomList
                    .stream()
                    .collect (
                            Collectors.groupingBy (
                                Function.identity(),
                                Collectors.reducing(0, (a, b) -> a + 1)
                            )
                    )
            );

        // g)
        System.out.println("Distinct elements.");
        final ArrayList<Integer> uniques =
            new ArrayList<Integer>(
                valuesFrequency
                    .entrySet()
                    .stream()
                    .filter(x -> x.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList())
            );
        System.out.println(uniques);
        System.out.println();

        // h)
        System.out.println("Duplicate elements.");
        final ArrayList<Integer> duplicates =
            new ArrayList<Integer>(
                valuesFrequency
                    .entrySet()
                    .stream()
                    .filter(x -> x.getValue() > 1)
                    .flatMap(x -> Collections.nCopies(x.getValue(), x.getKey()).stream())
                    .collect(Collectors.toList())
            );
        System.out.println(duplicates);
        System.out.println();

        // i)
        System.out.println("Array from list.");
        final Integer[] randomArray = new Integer[randomList.size()];
        randomList.toArray(randomArray);
        System.out.println(Arrays.toString(randomArray));
        System.out.println();

        // j)
        System.out.println("Values frequency.");
        final Map<Integer, Integer> numberFrequency = new HashMap<>();
        for(Integer number : randomList) {
            numberFrequency.put(number, numberFrequency.getOrDefault(number, 0) + 1);
        }
        System.out.println(numberFrequency.entrySet());
        System.out.println();
    }
}
