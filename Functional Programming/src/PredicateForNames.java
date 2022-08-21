import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        String[]text = scanner.nextLine().split("\\s+");
        Predicate<String>predicate = w -> w.length() <= num;

        for (String word : text) {
            if (predicate.test(word)){
                System.out.println(word);
            }
        }
    }
}
