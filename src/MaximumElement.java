import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer>stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
           String[] commands =  scanner.nextLine().split("\\s+");
           String command = commands[0];
           switch (command){
               case "1":
                   int number = Integer.parseInt(commands[1]);
                   stack.push(number);
                   break;
               case "2":
                   stack.pop();
                   break;
               case "3":
                 int max = Collections.max(stack);
                   System.out.println(max);
                   break;
           }
        }
    }
}
