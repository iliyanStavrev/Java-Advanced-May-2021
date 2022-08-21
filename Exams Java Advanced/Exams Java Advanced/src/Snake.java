import java.util.Scanner;

public class Snake {
    static int startRow = 0;
    static int startCol = 0;
    static int food = 0;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        char[][]matrix = new char[num][num];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'S'){
                    startRow = i;
                    startCol = j;
                }
            }
        }
        boolean isOut = false;
        while (food < 10 && !isOut){
            String input = scanner.nextLine();
            switch (input){
                case "up":
                  isOut = move(startRow,startCol,startRow - 1,startCol,matrix);
                    break;
                case "down":
                  isOut = move(startRow,startCol,startRow + 1,startCol,matrix);
                    break;
                case "left":
                  isOut =  move(startRow,startCol,startRow ,startCol - 1,matrix);
                    break;
                case "right":
                   isOut = move(startRow,startCol,startRow ,startCol + 1,matrix);
                    break;
            }
        }

        if (isOut){
            System.out.println("Game over!");
        }
        else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + food);
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

    private static boolean move(int beginRow, int beginCol, int newRow, int newCol, char[][] matrix) {
           matrix[beginRow][beginCol] = '.';
           if (outOfBounds(newRow,newCol,matrix)){
               return true;
           }
           char symbol = matrix[newRow][newCol];
           if (symbol == '*'){
               food++;
           }
           else if (symbol == 'B'){
               matrix[newRow][newCol] = '.';
               for (int i = 0; i < matrix.length; i++) {
                   for (int j = 0; j < matrix[i].length; j++) {
                       if (matrix[i][j] == 'B'){
                           newRow = i;
                           newCol = j;
                           break;
                       }
                   }
               }
           }
           matrix[newRow][newCol] = 'S';
           startRow = newRow;
           startCol = newCol;
           return false;
    }

    private static boolean outOfBounds(int newRow, int newCol, char[][] matrix) {
        return  newRow < 0 || newRow >= matrix.length ||
                newCol < 0 || newCol >= matrix[newRow].length;
    }
}
