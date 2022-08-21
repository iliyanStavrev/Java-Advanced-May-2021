import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer>numbers = Arrays.stream(scanner.nextLine().split("\\s+")).
          map(Integer::parseInt).collect(Collectors.toList());

        int division = Integer.parseInt(scanner.nextLine());

        Predicate<Integer>predicate = n -> n % division != 0;

        Collections.reverse(numbers);
        numbers.stream()
                .filter(e -> predicate.test(e))
                .forEach(n -> System.out.printf("%d ",n));

    }
}
