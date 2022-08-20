import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String []numbers = scanner.nextLine().split("\\s+");
        int length = Integer.parseInt(numbers[0]);
        int pop = Integer.parseInt(numbers[1]);
        int contains = Integer.parseInt(numbers[2]);

        String[]input = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer>stack = new ArrayDeque();
        for (int i = 0; i < input.length; i++) {
            stack.push(Integer.parseInt(input[i]));
        }

        for (int i = 0; i < pop; i++) {
              stack.pop();
        }
        if (stack.isEmpty()){
            System.out.println("0");
            return;
        }
        if (stack.contains(contains)){
            System.out.println("true");
        }
        else {
            int min = Collections.min(stack);
            System.out.println(min);
        }

    }
}
