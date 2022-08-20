import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer>numbers = new ArrayDeque<>();
      String[]tokens = scanner.nextLine().split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            String current = tokens[i];
            if (Character.isDigit(current.charAt(0))){
                numbers.push(Integer.parseInt(current));
            }
            else  {
                int nextNumber = Integer.parseInt(tokens[++i]);
                int result = current.equals("+")
                       ? numbers.peek() + nextNumber
                        : numbers.peek() - nextNumber;
                numbers.push(result);
            }
        }
        System.out.println(numbers.peek());
    }
}
