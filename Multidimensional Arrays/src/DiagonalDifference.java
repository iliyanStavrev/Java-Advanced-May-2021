import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][]matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
                int []arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt).toArray();
                matrix[i] = arr;
        }
        int primary = 0;
        int secondary = 0;

        for (int i = 0; i < matrix.length; i++) {
            primary += matrix[i][i];
            secondary += matrix[i][n - 1 - i];
        }
        int output = primary - secondary;
        System.out.println(Math.abs(output));
    }
}
