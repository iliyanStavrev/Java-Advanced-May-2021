import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String>userNames = new LinkedHashSet<>();

        while (n-- > 0){
            String input = scanner.nextLine();
           userNames.add(input);
        }
        userNames.stream()
                .forEach(e -> System.out.printf("%s%n",e));
    }
}
