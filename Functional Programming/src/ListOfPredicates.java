import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        if (num < 0){
            return;
        }

        int[]divisors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] numbers = new int[num];
        for (int i = 0; i < num; i++) {
            numbers[i] = i + 1;
        }


            Predicate<Integer>predicate = n -> {
                for (int divider : divisors) {
                     if (n % divider != 0){
                         return false;
                     }
                }
                return true;
            };

        for (int i = 0; i < numbers.length; i++) {
            if (predicate.test(numbers[i])){
                System.out.printf("%d ",numbers[i]);
            }
        }
    }
}
