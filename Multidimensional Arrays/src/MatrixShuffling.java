import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int []tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        String[][]matrix = new String[tokens[0]][tokens[1]];
        for (int i = 0; i < matrix.length; i++) {
           String [] arr = scanner.nextLine().split("\\s+");
            matrix[i] = arr;
        }
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[]commands = input.split("\\s+");
            String command = commands[0];
            if (commands.length != 5){
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }
            if (command.equals("swap")){
              int row1 = Integer.parseInt(commands[1]);
              int col1 = Integer.parseInt(commands[2]);
              int row2 = Integer.parseInt(commands[3]);
              int col2 = Integer.parseInt(commands[4]);
              if (row1 >= matrix.length || row2 >= matrix.length ||
                      col1 >= matrix[row1].length || col2 >= matrix[row2].length){
                  System.out.println("Invalid input!");
              }
              else {
                  String sub = matrix[row1][col1];
                  matrix[row1][col1] = matrix[row2][col2];
                  matrix[row2][col2] = sub;
                  printMatrix(matrix);
              }
            }
            else {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
