package org.example;

public class Human implements Comparable<Human>{
    protected final String firstName;
    protected final String lastName;
    protected final Integer age;

    public Human(final String firstName, final String lastName, final Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int compareTo(Human o) {
        return this.firstName.compareTo(o.firstName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "; " + age + " years";
    }
}
