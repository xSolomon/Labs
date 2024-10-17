
public class Bell {
    private boolean printDing = false;

    public void sound() {
        if ((printDing = !printDing) == true) {
            System.out.print("ding");
        } else {
            System.out.print("dong");
        }
    }
}
