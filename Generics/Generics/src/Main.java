import GenericSwapString.GenericSwapString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> elements = new ArrayList<>();
        GenericSwapString<String> genericSwap = new GenericSwapString("");
        for (int i = 0; i < n; i++) {

            elements.add(scanner.nextLine());
        }
        String[] input = scanner.nextLine().split("\\s+");
        int index1 = Integer.parseInt(input[0]);
        int index2 = Integer.parseInt(input[1]);

        genericSwap.swap(elements, index1, index2);

        for (String element : elements) {
            genericSwap = new GenericSwapString(element);
            System.out.println(genericSwap.toString());
        }
    }
}
