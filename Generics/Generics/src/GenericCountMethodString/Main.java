package GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      int n = Integer.parseInt(scanner.nextLine());

      List<String>elements = new ArrayList<>();
        Boxx<String>box = new Boxx<>("");
        for (int i = 0; i < n; i++) {

          elements.add(scanner.nextLine());
        }
        String input = scanner.nextLine();
      int out = box.getCount(elements, input);
        System.out.println(out);
    }

}
