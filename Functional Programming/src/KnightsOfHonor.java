import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Consumer<String> output = str -> Arrays.stream(str.split("\\s+"))
                .forEach(n ->
                        System.out.printf("Sir %s%n",n));

        output.accept(input);
    }
}
