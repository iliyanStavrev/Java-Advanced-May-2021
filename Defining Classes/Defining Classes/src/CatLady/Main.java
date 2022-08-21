package CatLady;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String,Cat>infoCat = new LinkedHashMap<>();

        while (!input.equals("End")){
            String []tokens = input.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            double characteristic = Double.parseDouble(tokens[2]);


           Cat cat = new Cat(breed,name,characteristic);
           infoCat.put(name,cat);


            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        if (infoCat.containsKey(input)){
            System.out.printf("%s %s %.2f",infoCat.get(input).breed,
                    infoCat.get(input).name,infoCat.get(input).characteristic);
        }
    }
}
