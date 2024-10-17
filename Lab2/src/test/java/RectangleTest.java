
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import exceptions.InvalidLengthException;
import exceptions.InvalidWidthException;
import geometry2d.Figure;
import geometry2d.Rectangle;

public class RectangleTest {
    private boolean isSideValid(final double side) {
        return (Double.compare(side, 0.0d) > 0) ? true : false;
    }

    private void checkValidRectangle(final double length, final double width)
        throws InvalidLengthException, InvalidWidthException {
        Figure rectangle = new Rectangle(length, width);
        assertEquals(2 * (length + width), rectangle.perimeter());
        assertEquals(length * width, rectangle.area());
        assertEquals("Rectangle: " + length + " length, " + width + " width.", rectangle.toString());
    }

    private void checkInvalidLength(final double length) {
        final InvalidLengthException exception = assertThrows(InvalidLengthException.class, () -> new Rectangle(length, 5.0));
        assertEquals("Rectangle length must be positive number.", exception.getMessage());
    }

    private void checkInvalidWidth(final double width) {
        final InvalidWidthException exception = assertThrows(InvalidWidthException.class, () -> new Rectangle(5.0, width));
        assertEquals("Rectangle width must be positive number.", exception.getMessage());
    }

    @RepeatedTest(10000)
    public void testGivenRandomSides() throws InvalidLengthException, InvalidWidthException {
        final Random randomRadiusGenerator = new Random();
        final double length = randomRadiusGenerator.nextDouble() * 100 - 50;
        final double width = randomRadiusGenerator.nextDouble() * 100 - 50;
        if (!isSideValid(length)) {
            checkInvalidLength(length);
            return;
        }
        if (!isSideValid(width)) {
            checkInvalidWidth(width);
            return;
        }
        checkValidRectangle(length, width);
    }
}
