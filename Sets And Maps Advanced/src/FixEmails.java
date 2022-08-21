import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        Map<String,String>info = new LinkedHashMap<>();

        while (!name.equals("stop")){
            String email = scanner.nextLine();
            String []tokens = email.split("\\.");
            String abriavation = tokens[tokens.length - 1];
            if (!abriavation.equals("us") && !abriavation.equals("uk")
                    && !abriavation.equals("com")){
                info.put(name,email);
            }
            name = scanner.nextLine();
        }
        info.entrySet()
                .forEach(e -> System.out.printf("%s -> %s%n",e.getKey(),e.getValue()));
    }
}
