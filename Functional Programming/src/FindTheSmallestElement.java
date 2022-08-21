import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int []numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] <= min){
                min = numbers[i];
                index = i;
            }
        }
        System.out.println(index);
    }
}
