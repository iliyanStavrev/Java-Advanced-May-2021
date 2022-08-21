import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     String input = scanner.nextLine();

     Function<String,Long> count = str ->
         Arrays.stream(str.split(", "))
                 .mapToInt(Integer::parseInt)
                 .count();

     Function<String,Integer>sum = str ->
             Arrays.stream(str.split(", "))
             .mapToInt(Integer::parseInt)
             .sum();

        System.out.println("Count = " + count.apply(input));
        System.out.println("Sum = " + sum.apply(input));
    }
}
