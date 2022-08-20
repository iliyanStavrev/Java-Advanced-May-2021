import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String [] tokens = input.split("");
        ArrayDeque<String>parentheses = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            parentheses.offer(tokens[i]);
        }
        boolean isBalanced = false;
        while (!parentheses.isEmpty()){

       String p = parentheses.peek();
       switch (p){
           case "{":
               if (parentheses.getLast().equals("}")){
                   parentheses.removeLast();
                   parentheses.pop();
                   isBalanced = true;
               }
               else {
                   isBalanced = false;
                   break;
               }
               break;
           case "(":
               if (parentheses.getLast().equals(")")){
                   parentheses.removeLast();
                   parentheses.pop();
                   isBalanced = true;
               }
               else {
                   isBalanced = false;
                   break;
               }
               break;
           case "[":
               if (parentheses.getLast().equals("]")){
                   parentheses.removeLast();
                   parentheses.pop();
                   isBalanced = true;
               }
               else {
                   isBalanced = false;
                   break;
               }
               break;
       }
       if (!isBalanced){
           System.out.println("NO");
           return;
       }
       else if (parentheses.size() % 2 == 1){
           System.out.println("NO");
           return;
       }
        }
        if (isBalanced){
            System.out.println("YES");
        }
    }
}
