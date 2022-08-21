import java.util.ArrayDeque;
import java.util.Scanner;

public class Cooking01easy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[]strings = scanner.nextLine().split("\\s+");
        String[]strings1 = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer>liquids = new ArrayDeque<>();
        ArrayDeque<Integer>ingredients = new ArrayDeque<>();
        for (int i = 0; i < strings.length; i++) {
            liquids.add(Integer.parseInt(strings[i]));
        }
        for (int i = 0; i < strings1.length; i++) {
            ingredients.push(Integer.parseInt(strings1[i]));
        }
        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()){
            int ingredient = ingredients.pop();
            int sum = liquids.pop() + ingredient;
            switch (sum){
                case 25:
                    bread++;
                    break;
                case 50:
                    cake++;
                    break;
                case 75:
                    pastry++;
                    break;
                case 100:
                    fruitPie++;
                    break;
                default:
                    ingredients.push(ingredient + 3);
            }
        }
        if (bread >= 1 && cake >= 1 && pastry >= 1 && fruitPie >= 1){
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
            System.out.println(liquids.toString().replaceAll("[\\[\\]]",""));
        }
        if (ingredients.isEmpty()){
            System.out.println("Ingredients left: none");
        }
        else {
            System.out.print("Ingredients left: ");
            System.out.println(ingredients.toString().replaceAll("[\\[\\]]",""));
        }
        System.out.printf("Bread: %d%nCake: %d%nFruit Pie: %d%nPastry: %d",bread,cake,fruitPie,pastry);
    }
}
