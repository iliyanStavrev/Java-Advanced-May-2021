import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[]numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        Function<Integer,Integer>add = n -> n + 1;
        Function<Integer,Integer>multiply = n -> n * 2;
        Function<Integer,Integer>substract = n -> n - 1;

        String input = scanner.nextLine();

        while (!input.equals("end")){

            switch (input){
                case "add":
                    for (int i = 0; i < numbers.length; i++) {
                       numbers[i] = add.apply(numbers[i]);
                    }
                    break;
                case "multiply":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = multiply.apply(numbers[i]);
                    }
                break;
                case "subtract":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = substract.apply(numbers[i]);
                    }
                    break;
                case "print":
                    for (int i = 0; i < numbers.length; i++) {
                        System.out.print(numbers[i] + " ");
                    }
                    System.out.println();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
