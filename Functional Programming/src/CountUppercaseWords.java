import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String>predicate = str -> Character.isUpperCase(str.charAt(0));

        String input = scanner.nextLine();

        List<String> words =  Arrays.stream(input.split("\\s+"))
                .filter(predicate).collect(Collectors.toList());

        System.out.println(words.size());
        System.out.println(words.stream().collect(Collectors.joining(System.lineSeparator())));
    }
}
