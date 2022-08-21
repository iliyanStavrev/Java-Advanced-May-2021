import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String,Map<String,Long>>infoCountry = new LinkedHashMap<>();
        Map<String,Long>infoPopulation = new LinkedHashMap<>();

        while (!input.equals("report")){
            String []tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
           long population = Integer.parseInt(tokens[2]);

            infoCountry.putIfAbsent(country,new LinkedHashMap<>());
            infoCountry.get(country).put(city,population);
            infoPopulation.putIfAbsent(country,0L);
            infoPopulation.put(country,infoPopulation.get(country) + population);

            input = scanner.nextLine();
        }
         infoCountry.entrySet().stream()
                 .sorted((c1,c2) ->
                      infoPopulation.get(c2.getKey()).compareTo(infoPopulation.get(c1.getKey())))
                 .forEach(country ->{
               System.out.printf("%s (total population: %d)%n",
                       country.getKey(),infoPopulation.get(country.getKey()));
               country.getValue().entrySet().stream()
                       .sorted((t1,t2) -> t2.getValue().compareTo(t1.getValue()))
                       .forEach(town -> System.out.printf("=>%s: %d%n",town.getKey(),town.getValue()));
                 });
    }
}
