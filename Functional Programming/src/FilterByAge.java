import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,Integer>person = new LinkedHashMap<>();

        while (n-- > 0){
            String input = scanner.nextLine();
            String []tokens = input.split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            person.put(name,age);
        }
        String condition = scanner.nextLine();
        int ageCondition = Integer.parseInt(scanner.nextLine());
        String typeFormat = scanner.nextLine();

        if (condition.equals("older")){
            typePrintOlder(person,typeFormat,ageCondition);
        }
        else if (condition.equals("younger")){
            typePrintYounger(person,typeFormat,ageCondition);
        }
    }

    private static void typePrintYounger(Map<String, Integer> person, String typeFormat, int ageCondition) {
        switch (typeFormat){
            case "name":
                getYonger(person,ageCondition)
                        .forEach(p -> System.out.printf("%s%n",p.getKey()));
                break;
            case "age":
                getYonger(person, ageCondition)
                        .forEach(e -> System.out.printf("%d%n",e.getValue()));
                break;
            case "name age":
                getYonger(person, ageCondition)
                        .forEach(p -> System.out.printf("%s - %d%n", p.getKey(), p.getValue()));
                break;
        }
    }

    private static void typePrintOlder(Map<String, Integer> person, String typeFormat, int ageCondition) {
        switch (typeFormat){
            case "name":
                getOlder(person,ageCondition)
                        .forEach(p -> System.out.printf("%s%n",p.getKey()));
                break;
            case "age":
                getOlder(person, ageCondition)
                        .forEach(e -> System.out.printf("%d%n",e.getValue()));
                break;
            case "name age":
                getOlder(person, ageCondition)
                        .forEach(p -> System.out.printf("%s - %d%n", p.getKey(), p.getValue()));
                break;
        }
    }

    private static Stream<Map.Entry<String, Integer>> getOlder(Map<String, Integer> person, int ageCondition) {
        return person.entrySet().stream()
                .filter(e -> e.getValue() >= ageCondition);
    }
    private static Stream<Map.Entry<String, Integer>> getYonger(Map<String, Integer> person, int ageCondition) {
        return person.entrySet().stream()
                .filter(e -> e.getValue() <= ageCondition);
    }
}


