import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int []numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int first = numbers[0];
        int second = numbers[1];
        int []one = new int[first];
        int []two = new int[second];
        for (int i = 0; i < first; i++) {
            int num = Integer.parseInt(scanner.nextLine());
           one[i] = num;
        }
        for (int i = 0; i < second; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            two[i] = num;
        }
        for (int i = 0; i < first; i++) {
            for (int j = 0; j < second; j++) {
                if (one[i] == two[j]){
                    System.out.print(one[i] + " ");
                }
            }
        }
    }
}
