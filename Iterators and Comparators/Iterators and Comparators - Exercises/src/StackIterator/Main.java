package StackIterator;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> stack = new ArrayList<>();
        String input = scanner.nextLine();
         String[]tokens = input.split("\\s+");
        for (int i = 1; i < tokens.length; i++) {
            if (i == tokens.length - 1){
                stack.add(Integer.parseInt(tokens[i]));
            }
            else {
                stack.add(Integer.parseInt(tokens[i].substring(0,tokens[i].length() - 1)));
            }
        }
        StackIterator stackIterator = new StackIterator(stack);

        input = scanner.nextLine();
        while (!input.equals("END")){
            String[]tokeni = input.split("\\s+");
            if (tokeni[0].equals("Pop")){

            stackIterator.pop();
            }
            else if (tokeni[0].equals("Push")){
                for (int i = 1; i < tokeni.length; i++) {
                    if (i == tokeni.length - 1){
                        stack.add(Integer.parseInt(tokeni[i]));
                    }
                    else {
                        stack.add(Integer.parseInt(tokeni[i].substring(0,tokeni[i].length() - 1)));
                    }
                }
            }

            input = scanner.nextLine();
        }
        stackIterator.print();
    }
}
