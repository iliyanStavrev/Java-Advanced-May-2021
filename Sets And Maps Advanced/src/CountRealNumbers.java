import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[]numbers = Arrays.stream(scanner.nextLine().split("\\s++"))
                .mapToDouble(Double::parseDouble).toArray();
        Map<Double,Integer>occurences = new LinkedHashMap<>();

        for (double number:numbers) {
            occurences.putIfAbsent(number,0);
            occurences.put(number,occurences.get(number) + 1);
        }
        occurences.entrySet()
                .forEach(e -> System.out.printf("%.1f -> %d%n",e.getKey(),e.getValue()));
    }
}
