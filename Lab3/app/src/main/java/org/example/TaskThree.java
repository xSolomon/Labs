package org.example;

import java.util.*;

public class TaskThree {
    public static void showTask() {
        System.out.println("Task 3.");
        final List<Human> humans = new ArrayList<>();
        humans.add(new Human("Paul", "Sallivan", 27));
        humans.add(new Human("Judith", "Beck", 50));
        humans.add(new Human("Alex", "Jaspers", 34));
        humans.add(new Human("Will", "Smith", 66));
        humans.add(new Human("Angela", "Oliver", 12));

        HashSet<Human> hashSet = new HashSet<>(humans);
        System.out.println(hashSet);
        System.out.println();

        LinkedHashSet<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println(linkedHashSet);
        System.out.println();

        TreeSet<Human> treeSet = new TreeSet<>(humans);
        System.out.println(treeSet);
        System.out.println();

        HumanComparatorByLastName comparator = new HumanComparatorByLastName();
        TreeSet<Human> treeSetWithComparator = new TreeSet<>(comparator);
        treeSetWithComparator.addAll(humans);
        System.out.println(treeSetWithComparator);
        System.out.println();

        TreeSet<Human> treeSetWithAgeComparator = new TreeSet<>((o1, o2 ) -> Integer.compare(o1.age, o2.age));
        treeSetWithAgeComparator.addAll(humans);
        System.out.println(treeSetWithAgeComparator);
        System.out.println();
        // Hashset - основана на хэш-таблице, т.е. порядок случаен и его постоянство не гарантируется.
        // LinkedHashSet - содержит ключи в порядке добавления в множество.
        // TreeSet - по умолчанию использует метод compareTo, реализованный для класса (в данном случае - сравнение по имени).
        // TreeSetWithComparator - использует отдельный класс компаратора, который сравнивает уже по фамилии.
        // TreeSetWithAgeComparator - использует лямбда-функцию, которая сравнивает людей по возрасту.
    }
}
