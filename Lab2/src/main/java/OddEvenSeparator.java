import java.util.ArrayList;

public class OddEvenSeparator {
    private ArrayList<Integer> evenNumbers = new ArrayList<>();
    private ArrayList<Integer> oddNumbers = new ArrayList<>();

    public void addNumber(int number) {
        if(number % 2 == 0) {
            evenNumbers.add(number);
        } else {
            oddNumbers.add(number);
        }
    }

    public void even() {
        System.out.print(evenNumbers);
    }

    public void odd() {
        System.out.print(oddNumbers);
    }
}
