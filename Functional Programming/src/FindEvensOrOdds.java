import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[]bounds = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        List<Integer>numbers = new ArrayList<>();
        for (int i = bounds[0]; i <= bounds[1] ; i++) {
            numbers.add(i);
        }
        Predicate<Integer> predicateOdd = n -> n % 2 == 1 || n % 2 == -1 ;
        Predicate<Integer>predicateEven = n -> n % 2 == 0;

        String input = scanner.nextLine();
        if (input.equals("odd")){
          getOddNumbers(numbers,predicateOdd).stream()
            .forEach(e -> System.out.printf("%d ",e));

        }
        else if (input.equals("even")){
          getEvenNumbers(numbers,predicateEven)
                  .forEach(e -> System.out.printf("%d ",e));
        }
    }

    private static List<Integer> getEvenNumbers(List<Integer> numbers, Predicate<Integer> predicateEven) {

        return  numbers.stream().filter(e -> predicateEven.test(e)).collect(Collectors.toList());
    }

    private static List<Integer> getOddNumbers(List<Integer> numbers, Predicate<Integer> predicateOdd) {

        return numbers.stream().filter(e -> predicateOdd.test(e)).collect(Collectors.toList());
    }
}
