package ListyIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        List<String>list = Arrays.stream(input.split("\\s+")).skip(1).collect(Collectors.toList());

        ListyIterator iterator = new ListyIterator(list);
        input = scanner.nextLine();

        while (!input.equals("END")){
            String[]tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command){

                case "Move":
                    System.out.println(iterator.move());
                    break;
                case "Print":
                     iterator.print();
                    break;
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
                case "PrintAll":
                    iterator.printAll();
                    System.out.println();
            }
            input = scanner.nextLine();
        }
    }

}
