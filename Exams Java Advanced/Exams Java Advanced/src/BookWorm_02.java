import java.util.Scanner;

public class BookWorm_02 {
  static int startRow = 0;
   static int startCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        int num = Integer.parseInt(scanner.nextLine());


        char[][] matrix = new char[num][num];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'P') {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("end")){

            switch (input){
                case "up":
               word = move(startRow,startCol,startRow - 1,startCol,matrix,word);
                    break;
                case "down":
                    word = move(startRow,startCol,startRow + 1,startCol,matrix,word);
                    break;
                case "left":
                    word = move(startRow,startCol,startRow ,startCol - 1,matrix,word);
                    break;
                case "right":
                    word = move(startRow,startCol,startRow,startCol + 1,matrix,word);
                    break;

            }

            input = scanner.nextLine();
        }
        System.out.println(word);
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

    private static String move(int beginRow, int beginCol, int newRow, int newCol, char[][] matrix, String word) {

        matrix[beginRow][beginCol] = '-';
        if (outOfBounds(newRow,newCol,matrix)){
            newRow = beginRow;
            newCol = beginCol;
            word = word.substring(0,word.length() - 1);
        }
        char symbol = matrix[newRow][newCol];
        if (Character.isLetter(symbol)){
            word += symbol;
        }
        matrix[newRow][newCol] = 'P';
        startRow = newRow;
        startCol = newCol;

        return word;
    }

    private static boolean outOfBounds(int newRow, int newCol, char[][] matrix) {
        return newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[newRow].length;
    }
}
