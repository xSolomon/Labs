import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

public class TableTest {
    @RepeatedTest(100)
    public void testRandomTables() {
        final Random randomIntGenerator = new Random();
        final int rows = randomIntGenerator.nextInt(100) + 1;
        final int cols = randomIntGenerator.nextInt(100) + 1;
        final int numbersCount = rows * cols;
        final int[] values = new int[numbersCount];
        Arrays.fill(values, randomIntGenerator.nextInt(201) - 100);
        final Table table = new Table(rows, cols);
        final int[] table_values = new int[cols * rows];
        double totalSum = 0.0;
        for(int i = 0; i < numbersCount; ++i) {
            table.setValue(i / cols, i % cols, values[i]);
            table_values[i] = table.getValue(i / cols , i % cols);
            totalSum += values[i];
        }
        final double average = totalSum / numbersCount;
        assertEquals(cols, table.cols());
        assertEquals(rows, table.rows());
        assertArrayEquals(values, table_values);
        assertEquals(Arrays.toString(values), table.toString());
        assertEquals(average, table.average());
    }
}
