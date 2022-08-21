package GenericSwapInteger;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> elements = new ArrayList<>();
        GenericSwapInteger<Integer> genericSwap = new GenericSwapInteger<>(0);
        for (int i = 0; i < n; i++) {

            elements.add(Integer.parseInt(scanner.nextLine()));
        }
        String[] input = scanner.nextLine().split("\\s+");
        int index1 = Integer.parseInt(input[0]);
        int index2 = Integer.parseInt(input[1]);

        genericSwap.swap(elements, index1, index2);

        for (Integer element : elements) {
            genericSwap = new GenericSwapInteger(element);
            System.out.println(genericSwap.toString());
        }
    }
}
