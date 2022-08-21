import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String,Map<String,Double>>infoShop = new TreeMap<>();

        while (!input.equals("Revision")){
            String []tokens = input.split(",\\s+");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            infoShop.putIfAbsent(shop,new LinkedHashMap<>());
            infoShop.get(shop).put(product,price);

            input = scanner.nextLine();
        }
        infoShop.entrySet().stream()
                .forEach(k -> {
                    System.out.printf("%s->%n",k.getKey());
                    k.getValue().entrySet().stream()
                    .forEach(p -> System.out.printf("Product: %s, Price: %.1f%n",p.getKey(),p.getValue()) );
                });
    }
}
