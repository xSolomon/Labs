
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import exceptions.InvalidHeightException;
import exceptions.InvalidRadiusException;
import geometry2d.Circle;
import geometry3d.Cylinder;

public class CylinderTest {
    private boolean isHeightValid(final double height) {
        return (Double.compare(height, 0.0d) > 0) ? true : false;
    }

    private void checkValidCylinder(final double radius, final double height)
        throws InvalidRadiusException, InvalidHeightException {
        Circle circle = new Circle(radius);
        Cylinder cylinder = new Cylinder(circle, height);
        assertEquals(circle.area() * height, cylinder.volume());
    }

    private void checkInvalidHeight(final double radius, final double height) {
        final InvalidHeightException exception =
            assertThrows(InvalidHeightException.class, () -> new Cylinder(new Circle(radius), height));
        assertEquals("Cylinder height must be positive number.", exception.getMessage());
    }

    @RepeatedTest(10000)
    public void testGivenRandomHeight() throws InvalidRadiusException, InvalidHeightException {
        final Random randomRadiusGenerator = new Random();
        final double radius = randomRadiusGenerator.nextDouble() * 100 + 1;
        final double height = randomRadiusGenerator.nextDouble() * 100 - 50;
        if (isHeightValid(height)) {
            checkValidCylinder(radius, height);
        }
        else {
            checkInvalidHeight(radius, height);
        }
    }
}
