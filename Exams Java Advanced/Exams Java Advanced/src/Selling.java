import java.util.Scanner;

public class Selling {
        static   int beginRow = 0;
        static   int beginCol = 0;
       static int sum = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

       char[][]matrix = new char[num][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'S'){
                    beginRow = i;
                    beginCol = j;
                }
            }
        }
        boolean isInBakery = true;

        while (sum < 50 && isInBakery){

            String input = scanner.nextLine();

            switch (input){
                case "up":
                isInBakery = move(beginRow, beginCol, beginRow - 1, beginCol,matrix);
                    break;
                case "down":
                 isInBakery = move(beginRow, beginCol, beginRow + 1, beginCol,matrix);
                    break;
                case "left":
                  isInBakery = move(beginRow, beginCol, beginRow, beginCol - 1,matrix);
                    break;
                case "right":
                 isInBakery = move(beginRow, beginCol, beginRow, beginCol + 1,matrix);
                    break;
            }
        }
        if (!isInBakery){
            System.out.println("Bad news, you are out of the bakery.");
        }
        else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.println("Money: " + sum);
        printMatrix(matrix);
    }

    private static boolean move(int row, int col,int newRow,int newCol, char[][] matrix) {

        matrix[row][col] = '-';

        if (validatingMatrix(matrix,newRow,newCol)){
            return false;
        }
        char symbol = matrix[newRow][newCol];

        if (Character.isDigit(symbol)){
            sum += symbol - '0';
        }
        else if (symbol == 'O'){
            matrix[newRow][newCol] = '-';
            for (int i = 0 ; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 'O'){
                        newRow = i;
                        newCol = j;
                        break;
                    }
                }
            }
        }
        matrix[newRow][newCol] = 'S';
        beginRow = newRow;
        beginCol = newCol;
        return true;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean validatingMatrix(char[][] matrix,int row,int col) {

      return row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length;
    }
}
