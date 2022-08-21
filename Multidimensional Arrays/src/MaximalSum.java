import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int [][]matrix = new int[tokens[0]][tokens[1]];
        for (int i = 0; i < matrix.length; i++) {
            int []arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                sum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2]
                        +  matrix[i + 1][j] +  matrix[i + 1][j + 1] +  matrix[i +1][j + 2]
                        + matrix[i + 2][j] +  matrix[i + 2][j + 1] +  matrix[i + 2][j + 2];
                if (sum > maxSum){
                    maxSum = sum;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
 System.out.println(matrix[maxRow][maxCol]+" "+matrix[maxRow][maxCol + 1] +" "+ matrix[maxRow][maxCol + 2] +" ");
 System.out.println(matrix[maxRow+1][maxCol]+" "+matrix[maxRow + 1][maxCol + 1] +" "+ matrix[maxRow + 1][maxCol + 2] +" ");
 System.out.println(matrix[maxRow+2][maxCol]+" "+matrix[maxRow + 2][maxCol + 1] +" "+ matrix[maxRow + 2][maxCol + 2] +" ");
    }
}
