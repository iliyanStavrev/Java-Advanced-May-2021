package CustomList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        CustomList customList = new CustomList();
        String input = scanner.nextLine();

        while (!input.equals("END")){
          String[]tokens = input.split("\\s+");
          String command = tokens[0];

          switch (command){
              case "Add":
                  String element = tokens[1];
                  customList.add(element);
                  break;
              case "Remove":
                  int index = Integer.parseInt(tokens[1]);
                  customList.remove(index);
                  break;
              case "Contains":
                  element = tokens[1];
                  System.out.println(customList.contains(element));
                  break;
              case "Swap":
                  index = Integer.parseInt(tokens[1]);
                 int index1 = Integer.parseInt(tokens[2]);
                 customList.swap(index,index1);
                  break;
              case "Greater":
                  element = tokens[1];
                  System.out.println(customList.greater(element));
                  break;
              case "Max":
                  System.out.println(customList.max());
                  break;
              case "Min":
                  System.out.println(customList.min());
                  break;
              case "Sort":
                  customList.sort();
                  break;
              case "Print":
                  System.out.println(customList.toString());
                  break;
          }
            input = scanner.nextLine();
        }

    }
}
