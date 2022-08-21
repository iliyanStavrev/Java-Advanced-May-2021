import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, ArrayList<Double>>info = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[]tokens = input.split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);
          info.putIfAbsent(name,new ArrayList<>());
          info.get(name).add(grade);
        }
        info.entrySet().stream()
          .forEach(e -> {
              System.out.print(e.getKey() + " -> ");
              e.getValue().forEach(y -> System.out.printf("%.2f ",y));
              System.out.printf("(avg: %.2f)%n",e.getValue().stream().mapToDouble(x -> x).average().orElse(0.0));
          });

    }
}
