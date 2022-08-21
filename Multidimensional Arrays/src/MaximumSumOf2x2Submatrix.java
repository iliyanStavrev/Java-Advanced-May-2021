import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int [][]matrix = new int[dimensions[0]][];
        for (int i = 0; i < matrix.length; i++) {
            int []arr = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int maxRow = 0;
        int maxCol = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int sum = 0;
                sum = matrix[i][j] + matrix[i][j+1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (sum > maxSum){
                    maxSum = sum;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println(matrix[maxRow][maxCol] + " " + matrix[maxRow][maxCol + 1]);
        System.out.println(matrix[maxRow +1][maxCol] + " " + matrix[maxRow + 1][maxCol + 1]);
        System.out.println(maxSum);
    }
}
