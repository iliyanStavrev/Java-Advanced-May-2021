import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<String>input = new ArrayList<>();
      getCounter(scanner,command,input);

        String inputCommand = input.get(0);
        int degrees = getDegrees(inputCommand);
       int length = Integer.MIN_VALUE;

        for (int i = 1; i < input.size(); i++) {
            if (input.get(i).length() > length){
                length = input.get(i).length();
            }
        }
        input.remove(0);
        char[][] matrix = new char[input.size()][length];

        for (int i = 0; i < matrix.length; i++) {

           matrix[i] = input.get(i).toCharArray();
        }
        while (degrees >= 360){
           degrees =  degrees % 360;
        }
        if (degrees == 0){
          printMatrix(matrix,length);
        }
        else if (degrees == 90){
          matrix90degrees(matrix,length);
        }
        else if (degrees == 180){
          matrix180degrees(matrix,length);
        }
        else if (degrees == 270){
          matrix270degrees(matrix,length);
        }
    }

    private static void matrix270degrees(char[][] matrix, int length) {
        char[][]newMatrix = new char[length][matrix.length];
        int i = 0;
        for (int c = 0; c < newMatrix[matrix.length].length; c++) {
            int j = 0;
            for (int r = newMatrix.length - 1; r >= 0; r--) {
                if (j < matrix[i].length) {
                    newMatrix[r][c] = matrix[i][j];
                }
                j++;
            }
            i++;
        }
        printMatrix(newMatrix,length);
    }

    private static void matrix180degrees(char[][] matrix, int length) {
       char[][]newMatrix = new char[matrix.length][length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = matrix[r].length - 1; c >= 0; c--) {
                newMatrix[matrix.length - 1 - r][c] = matrix[r][matrix[r].length - 1 - c];
            }
        }
         printMatrix(newMatrix,length);
        
    }

    private static void matrix90degrees(char[][] matrix, int length) {
        char[][]rotatedMatrix = new char[length][matrix.length];
        int i = 0;
        for (int c = matrix.length - 1; c >= 0 ; c--) {
            int j = 0;
            for (int r = 0; r < matrix[i].length; r++) {
                rotatedMatrix[r][c] = matrix[i][j];
                j++;
            }i++;
        }
        printMatrix(rotatedMatrix,length);
    }

    private static void printMatrix(char[][] matrix, int length) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][j] = ' ';
                }
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int getDegrees(String inputCommand) {
        return Integer.parseInt(inputCommand.substring(7,inputCommand.length() - 1));
    }

    private static void   getCounter(Scanner scanner, String command,List<String>input) {
        int counter = -1;
        while (!command.equals("END")){

            input.add(command);
            counter ++;

            command = scanner.nextLine();
        }

    }
}
