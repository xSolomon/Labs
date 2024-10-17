import java.util.Arrays;
import java.util.Random;

import exceptions.*;
import geometry2d.*;
import geometry3d.*;

public class App {
    public static void main(String[] args) {
        final Random randomIntGenerator = new Random();

        System.out.println("Button:");
        final Button button = new Button();
        button.click();
        System.out.println();
        button.click();
        System.out.println();
        button.click();
        System.out.println();
        button.click();
        System.out.println();
        System.out.println();

        System.out.println("Balance:");
        final Balance balance = new Balance();
        balance.result();
        System.out.println();
        balance.addLeft(0);
        balance.addRight(0);
        balance.result();
        System.out.println();
        balance.addLeft(100);
        balance.result();
        System.out.println();
        balance.addRight(1000);
        balance.result();
        System.out.println();
        System.out.println();

        System.out.println("Bell:");
        final Bell bell = new Bell();
        bell.sound();
        System.out.println();
        bell.sound();
        System.out.println();
        bell.sound();
        System.out.println();
        bell.sound();
        System.out.println();
        bell.sound();
        System.out.println();
        System.out.println();

        System.out.println("OddEvenSeparator:");
        final OddEvenSeparator numberSeparator = new OddEvenSeparator();
        int numberCount = 20;
        int[] numbers = new int[numberCount];
        for (int i = 0; i < numberCount; ++i) {
            numbers[i] = randomIntGenerator.nextInt(201) - 100;
            numberSeparator.addNumber(numbers[i]);
        }
        System.out.println("Unseparated numbers:");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Even numbers:");
        numberSeparator.even();
        System.out.println();
        System.out.println("Odd numbers:");
        numberSeparator.odd();
        System.out.println();
        System.out.println();

        System.out.println("Table:");
        final int rows = 1, cols = 5;
        final Table table = new Table(rows, cols);
        for(int i = 0; i < rows * cols; ++i) {
            table.setValue(i / cols, i % cols, randomIntGenerator.nextInt(201) -100);
        }
        System.out.println("Average value is: " + table.average());
        System.out.println("Table values:");
        System.out.println(table);
        System.out.println();

        
        System.out.println("Circle:");
        try
        {
            final Figure circle = new Circle(10);
            System.out.println(circle);
            System.out.println("Circle perimeter: " + circle.perimeter());
            System.out.println("Circle area: " + circle.area());
            final Figure badCircle = new Circle(-10);
        }
        catch (final InvalidRadiusException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println();
        System.out.println("Rectangle: ");
        try
        {
            final Figure rectangle = new Rectangle(7, 8);
            System.out.println(rectangle);
            System.out.println("Rectangle perimeter: " + rectangle.perimeter());
            final Figure badRectangle = new Rectangle(0, 10);
        }
        catch (final Exception exception) {
            System.out.println(exception.getMessage());
        }
        try {
            final Figure badRectangle = new Rectangle(1, 0);
        }
        catch (final Exception exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println();

        System.out.println("Cylinder:");
        try {
            final Cylinder cylinder = new Cylinder(new Circle(10), 6);
            System.out.println("Cylinder volume: " + cylinder.volume());
            final Cylinder badCylinder = new Cylinder(new Circle(10), 0);
        }
        catch (final Exception exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println();
    }

}