import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String>orders = new ArrayDeque<>();

        while (!input.equals("print")){
            if (!input.equals("cancel")){
                orders.offer(input);
            }
            else {
                if (orders.isEmpty()){
                    System.out.println("Printer is on standby");
                }
                else {
                    System.out.println("Canceled " + orders.poll());
                }
            }
            input = scanner.nextLine();
        }
        while (!orders.isEmpty()){
            System.out.println(orders.poll());
        }
    }
}
