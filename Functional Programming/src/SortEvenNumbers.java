import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0).toArray();

        System.out.println(formatedString(numbers));
        Arrays.sort(numbers);
        System.out.println(formatedString(numbers));

    }

    private static String formatedString(int[] numbers) {

      return   Arrays.stream(numbers)
                .mapToObj(String::valueOf)
              .collect(Collectors.joining(", "));
    }
}
