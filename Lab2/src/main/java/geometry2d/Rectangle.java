package geometry2d;

public class Rectangle implements Figure {
    private double length;
    private double width;

    public Rectangle(final double length, final double width)
        throws exceptions.InvalidLengthException, exceptions.InvalidWidthException {
        if (length <= 0) {
            throw new exceptions.InvalidLengthException("Rectangle length must be positive number.");
        }
        if (width <= 0) {
            throw new exceptions.InvalidWidthException("Rectangle width must be positive number.");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return "Rectangle: " + length + " length, " + width + " width.";
    }
}
