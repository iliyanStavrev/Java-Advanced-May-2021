import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,Double> infoStudents = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String []scores = scanner.nextLine().split("\\s+");
            double sum = 0;
            for (int j = 0; j < scores.length; j++) {
                sum += Double.parseDouble(scores[j]);
            }
            double average = sum / scores.length;
           infoStudents.putIfAbsent(name,0.0);
           infoStudents.put(name,average);
        }DecimalFormat format = new DecimalFormat("#.#############");
        infoStudents.entrySet()
                .forEach(e -> System.out.printf("%s is graduated with %s%n",e.getKey(),format.format(e.getValue())));
    }
}
