import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String,String>phoneBook = new LinkedHashMap<>();

        while (!input.equals("search")){
            String[]tokens = input.split("-");
            String name = tokens[0];
            String phone = tokens[1];

            phoneBook.put(name,phone);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("stop")){
            if (phoneBook.containsKey(input)){
                System.out.println(input + " -> " + phoneBook.get(input));
            }
            else {
                System.out.printf("Contact %s does not exist.%n",input);
            }

            input = scanner.nextLine();
        }
    }
}
