package geometry3d;

public class Cylinder {
    private final geometry2d.Circle base;
    private final double height;

    public Cylinder(final geometry2d.Circle base, final double height)
        throws exceptions.InvalidHeightException {
        if (height <= 0) {
            throw new exceptions.InvalidHeightException("Cylinder height must be positive number.");
        }
        this.base = base;
        this.height = height;
    }

    public double volume() {
        return base.area() * height;
    }
}
