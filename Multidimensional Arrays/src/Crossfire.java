import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int []dimenssions  = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int number = 1;
      String [][] matrix = new String[dimenssions[0]][dimenssions[1]];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = number ++ +"";
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")){
            int [] tokens = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int row = tokens[0];
            int col = tokens[1];
            int rad = tokens[2];

            for (int i = row - rad; i <= row + rad ; i++) {
                if (isRanged(i,col,matrix) && i != row){
                    matrix[i][col] = " ";
                }
            }
            for (int i = col + rad; i >= col - rad ; i--) {
               if (isRanged(row,i,matrix)){
                  matrix[row][i] = " ";
               }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }



    private static boolean isRanged(int row, int col, String[][] matrix) {
        return  row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
