import java.util.*;
import java.util.stream.Collectors;

public class Cooking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer>liquids = new ArrayDeque<>();
        String []input = scanner.nextLine().split("\\s+");
        for (int i = 0; i < input.length; i++) {
            liquids.offer(Integer.parseInt(input[i]));
        }

        ArrayDeque<Integer>ingredients = new ArrayDeque<>();
        String []input1 = scanner.nextLine().split("\\s+");
        for (int i = 0; i < input1.length; i++) {
            ingredients.push(Integer.parseInt(input1[i]));
        }

        Map<String,Integer>table = new LinkedHashMap<>();
        table.put("Bread",25);
        table.put("Cake",50);
        table.put("Pastry",75);
        table.put("Fruit Pie",100);

        Map<String,Integer>productAmount = new TreeMap<>();

        while (!liquids.isEmpty() && !ingredients.isEmpty()){
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();

            int sum = liquid + ingredient;
            for (String s : table.keySet()) {
                productAmount.putIfAbsent(s,0);
            }

            String product = getProduct(table,sum);

           if(orderProduct(table,sum)){

          productAmount.put(product,productAmount.get(product) + 1);
           }
           else {
               ingredients.push(ingredient + 3);
           }
        }
        if (completingAllFoods(productAmount)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }
           else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }
        if (liquids.isEmpty()){
            System.out.println("Liquids left: none");
        }
        else {
            System.out.print("Liquids left: ");
            System.out.println(liquids.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if (ingredients.isEmpty()){
            System.out.println("Ingredients left: none");
        }
        else {
            System.out.print("Ingredients left: ");
            System.out.println(ingredients.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));

        }
              productAmount.entrySet().
                      forEach(e ->
                              System.out.printf("%s: %d%n",e.getKey(),e.getValue()));
            }


    private static boolean completingAllFoods(Map<String, Integer> productAmount) {
        for (Integer value : productAmount.values()) {
            if (value == 0){
                return false;
            }
        }
        return true;
    }

    private static String getProduct(Map<String, Integer> table, int sum) {
         String product = "";
        for (Map.Entry<String, Integer> entry : table.entrySet()) {
            if (sum == entry.getValue()){
                product = entry.getKey();
            }
        }
        return product;
    }

    private static boolean orderProduct(Map<String, Integer> table, int sum) {

        for (Integer value : table.values()) {
            if (sum == value){
                return  true;
            }
        }
        return false;
    }
}
