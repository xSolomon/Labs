
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import exceptions.InvalidRadiusException;
import geometry2d.Figure;
import geometry2d.Circle;

public class CircleTest {
    private boolean isRadiusValid(final double radius) {
        return (Double.compare(radius, 0.0d) > 0) ? true : false;
    }

    private void checkValidCircle(final double radius) throws InvalidRadiusException {
        Figure circle = new Circle(radius);
        assertEquals(2 * Math.PI * radius, circle.perimeter());
        assertEquals(Math.PI * Math.pow(radius, 2), circle.area());
        assertEquals("Circle: " + radius + " radius.", circle.toString());
    }

    private void checkInvalidRadius(final double radius) {
        final InvalidRadiusException exception = assertThrows(InvalidRadiusException.class, () -> new Circle(radius));
        assertEquals("Circle radius must be positive number.", exception.getMessage());
    }

    @RepeatedTest(10000)
    public void testGivenRandomRadius() throws InvalidRadiusException {
        final Random randomRadiusGenerator = new Random();
        final double radius = randomRadiusGenerator.nextDouble() * 100 - 50;
        if (isRadiusValid(radius)) {
            checkValidCircle(radius);
        }
        else {
            checkInvalidRadius(radius);
        }
    }
}
