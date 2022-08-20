import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[]numbers = scanner.nextLine().split("\\s+");
        ArrayDeque<String>stack = new ArrayDeque<>();
        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
