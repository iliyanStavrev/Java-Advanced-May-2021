package GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Double> elements = new ArrayList<>();
        Box<Double> box = new Box<>(0.0);
        for (int i = 0; i < n; i++) {

            elements.add(Double.parseDouble(scanner.nextLine()));
        }
        Double input = Double.parseDouble(scanner.nextLine());
        int out = box.getCount(elements, input);
        System.out.println(out);
    }
}
