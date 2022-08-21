import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Map<String,Map<String, List<String>>>infoContinent = new LinkedHashMap<>();

        for (int i = 0; i < number; i++) {
            String input = scanner.nextLine();
            String[]tokens = input.split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            infoContinent.putIfAbsent(continent,new LinkedHashMap<>());
            infoContinent.get(continent).putIfAbsent(country,new ArrayList<>());
            infoContinent.get(continent).get(country).add(city);
        }
        infoContinent.entrySet().stream()
                .forEach(c ->{
                    System.out.printf("%s:%n",c.getKey());
                c.getValue()
                  .forEach((k,v)-> {
                      System.out.printf("  %s -> %s%n",k,String.join(", ",v));
                  });
                });
    }
}
