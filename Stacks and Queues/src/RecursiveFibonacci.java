import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int index = Integer.parseInt(scanner.nextLine());

        List<Long>numbers = new ArrayList<>();
        numbers.add(1L);
        numbers.add(1L);
        for (int i = 2; i < 50; i++) {
           numbers.add(numbers.get(i - 2) + numbers.get(i - 1));
        }
        System.out.println(numbers.get(index));
    }
}
