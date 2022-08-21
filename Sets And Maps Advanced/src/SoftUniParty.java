import java.util.*;
import java.util.stream.Collectors;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String>vip = new TreeSet<>();
        Set<String>regular = new TreeSet<>();

        while (!input.equals("PARTY")){
           if (Character.isDigit(input.charAt(0))){
               vip.add(input);
           }
           else {
               regular.add(input);
           }

            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("END")){
            if (Character.isDigit(input.charAt(0))){
                vip.remove(input);
            }
            else {
                regular.remove(input);
            }
            input = scanner.nextLine();
        }
        System.out.println(vip.size() + regular.size());
          vip.forEach(e -> System.out.printf("%s%n",e));
          regular.forEach(e -> System.out.printf("%s%n",e));
    }
}
