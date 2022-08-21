import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double>vat = v -> v * 1.2;

        double[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble).toArray();

        System.out.println("Prices with VAT:");

         Arrays.stream(numbers)
               .map(e -> vat.apply(e))
                 .forEach(n ->
                            System.out.printf("%.2f%n",n));

    }
}
