import java.util.Arrays;

public class Table {
    private final int[] numbers;
    private final int rows;
    private final int cols;

    public Table(final int rows, final int cols) {
        this.rows = rows;
        this.cols = cols;
        this.numbers = new int[rows * cols];
    }

    public int getValue(final int row, final int col) {
        return numbers[row * cols + col];
    }

    public void setValue(final int row, final int col, final int value) {
        numbers[row * cols + col] = value;
    }

    public int rows() {
        return this.rows;
    }

    public int cols() {
        return this.cols;
    }

    public String toString() {
        return Arrays.toString(numbers);
    }

    public double average() {
        double accumulator = 0.0;
        for(int number : numbers) {
            accumulator += number;
        }
        return accumulator / (rows * cols);
    }
}
