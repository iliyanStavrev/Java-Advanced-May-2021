import java.util.*;
import java.util.function.Predicate;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      int []numbers  = Arrays.stream(scanner.nextLine().split("\\s+"))
              .mapToInt(Integer::parseInt).toArray();

        Predicate<Integer>predicateEven = n -> n % 2 == 0;


        List<Integer>even = new ArrayList<>();
        List<Integer>odd = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (predicateEven.test(numbers[i])){
                even.add(numbers[i]);
            }
            else {
                odd.add(numbers[i]);
            }
        }
        Collections.sort(even);
        Collections.sort(odd);
        even.forEach(n -> System.out.printf("%d ",n));
        odd.forEach(n -> System.out.printf("%d ",n));
    }
}
