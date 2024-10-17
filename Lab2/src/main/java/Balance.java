
public class Balance {
    private int weightLeft = 0;
    private int weightRight = 0;

    public void addLeft(final int weight) {
        weightLeft += weight;
    }

    public void addRight(final int weight) {
        weightRight += weight;
    }

    public void result() {
        if (weightLeft == weightRight) {
            System.out.print('=');
        } else if (weightLeft > weightRight) {
            System.out.print('L');
        } else {
            System.out.print('R');
        }
    }
}
