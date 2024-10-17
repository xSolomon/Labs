package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static java.util.Map.entry;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        final Gson gson = new Gson();
        final List<Visitor> visitors;
        try (final FileReader reader = new FileReader("src/main/resources/books.json")) {
            visitors = gson.fromJson(reader, new TypeToken<List<Visitor>>(){}.getType());
        }
        catch(IOException exception) {
            System.err.println("An error occured during execution:");
            System.err.println(exception.getMessage());
            return;
        }

        System.out.println("Task 1.");
        System.out.println("Total visitors: " +
            visitors
                .stream()
                .peek(x -> System.out.println("Name: " + x.getName() + " Surname: " + x.getSurname()))
                .reduce(0, (identity, val) -> identity + 1, Integer::sum));
        System.out.println();

        final List<Book> books =
            visitors
                .stream()
                .flatMap(x -> x.getFavoriteBooks().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Task 2.");
        System.out.println("Total books favored by visitors: " +
            books
                .stream()
                .peek(x -> System.out.println("Name: " + x.getName() + " Author: " + x.getAuthor() + " Year: " + x.getPublishingYear()))
                .reduce(0, (identity, val) -> identity + 1, Integer::sum));
        System.out.println();

        System.out.println("Task 3.");
        books
            .stream()
            .sorted(Comparator.comparing(Book::getPublishingYear))
            .peek(x -> System.out.println("Name: " + x.getName() + " Author: " + x.getAuthor() + " Year: " + x.getPublishingYear()))
            .collect(Collectors.toList());
        System.out.println();

        System.out.println("Task 4.");
        System.out.println("Presence of the author \"Jane Austen\": " +
            books
                .stream()
                .anyMatch(x -> x.getAuthor().equals("Jane Austen")));
        System.out.println();

        System.out.println("Task 5.");

        System.out.println("Maximum books that were favorited: " +
            visitors
                .stream()
                .map(x -> x.getFavoriteBooks().size())
                .max(Integer::compare).orElse(0));
        System.out.println();

        System.out.println("Task 6.");
        final Integer averageFavoredBooks = 
            visitors
                .stream()
                .map(x -> x.getFavoriteBooks().size())
                .collect(
                    Collectors.teeing(
                        Collectors.summingInt(x -> x),
                        Collectors.reducing(0, (acc, val) -> acc + 1),
                        (sum, n) -> Math.ceilDiv(sum, n)
                    )
                );

        final Map<Integer, String> averageCmpToTest = Map.ofEntries(
            entry(-1, "read more"),
            entry(0, "fine"),
            entry(1, "you are a bookworm")
        );
        System.out.println("Average: " + averageFavoredBooks);
        visitors
            .stream()
            .filter(visitor -> visitor.isSubscribed())
            .collect(
                Collectors.groupingBy(
                    visitor -> averageCmpToTest.get(Double.compare(
                        visitor.getFavoriteBooks().size(),
                        averageFavoredBooks))))
            .entrySet()
            .stream()
            .flatMap(
                mapEntry -> 
                    mapEntry.getValue()
                        .stream()
                        .map(
                            visitor -> new Sms(visitor.getPhone(), mapEntry.getKey())))
            .peek(sms -> System.out.println(sms))
            .collect(Collectors.toList());
        System.out.println();
    }
}
