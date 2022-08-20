import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer>indexes = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char current  = input.charAt(i);

            if (current == '('){
                indexes.push(i);
            }
            else if (current == ')'){
                int startIndex = indexes.pop();
                System.out.println(input.substring(startIndex,i + 1));
            }
        }
    }
}
