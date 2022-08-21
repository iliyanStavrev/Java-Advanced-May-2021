import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String,Integer>infoResources = new LinkedHashMap<>();

        while (!input.equals("stop")){
            int quantity = Integer.parseInt(scanner.nextLine());
            infoResources.putIfAbsent(input,0);
            infoResources.put(input,infoResources.get(input) + quantity);

            input = scanner.nextLine();
        }
        infoResources.entrySet()
                .forEach(e-> System.out.printf("%s -> %d%n",e.getKey(),e.getValue()));
    }
}
