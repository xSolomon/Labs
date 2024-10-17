package geometry2d;

public class Circle implements Figure {
    private double radius;

    public Circle(final double radius) throws exceptions.InvalidRadiusException {
        if(radius <= 0) {
            throw new exceptions.InvalidRadiusException("Circle radius must be positive number.");
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle: " + radius + " radius.";
    }
}
