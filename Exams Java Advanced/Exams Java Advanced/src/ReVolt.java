import java.util.Scanner;

public class ReVolt {
    public static int startRow = 0;
    public static int startCol = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int numCommands = Integer.parseInt(scanner.nextLine());
        char[][]matrix = new char[num][num];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'f'){
                    startRow = i;
                    startCol = j;
                }
            }
        }
        String commands = scanner.nextLine();
        matrix[startRow][startCol] = '-';
        boolean hasWon = false;
        for (int i = 0; i < numCommands; i++) {

            int previousRow = startRow;
            int previousCol = startCol;
            char symbol;

            switch (commands){
                case "up":
                    startRow--;
                    if (startRow < 0){
                        startRow = matrix.length - 1;
                    }
                    break;
                case "down":
                    startRow++;
                    if (startRow>= matrix.length){
                       startRow = 0;
                    }
                    break;
                case "left":
                    startCol--;
                    if (startCol < 0){
                        startCol = matrix.length - 1;
                    }
                    break;
                case "right":
                    startCol++;
                    if (startCol >= matrix.length){
                       startCol = 0;
                    }
                    break;
            }
            symbol = matrix[startRow][startCol];
            if (symbol == 'F'){
                System.out.println("Player won!");
                hasWon = true;
                break;
            }
            else if (symbol == 'B'){
                matrix[startRow][startCol] = 'B';
                numCommands++;
                continue;
            }
           else if (symbol == 'T'){
                startRow = previousRow;
                startCol = previousCol;
            }
          if (i == numCommands - 1){
              break;
          }
        commands = scanner.nextLine();
        }
        matrix[startRow][startCol] = 'f';
        if (!hasWon){
            System.out.println("Player lost!");
        }
        print(matrix);
    }

    private static void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
