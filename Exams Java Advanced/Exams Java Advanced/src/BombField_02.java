import java.util.Scanner;

public class BombField_02 {
    public static int startRow = 0;
    public static int startCol = 0;
    public static int bombs = 0;
    public static int neededBombs = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String[][]matrix = new String[num][num];

        boolean isDone = false;
        String[]tokens = scanner.nextLine().split(",");
        for (int i = 0; i < matrix.length; i++) {

            matrix[i] = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("s")){
                    startRow = i;
                    startCol = j;
                }
                else if (matrix[i][j].equals("B")){
                    bombs++;
                }
            }
        }
        for (int i = 0; i < tokens.length; i++) {
            String command = tokens[i];
            switch (command) {
                case "up":
                    isDone = move(startRow, startCol, startRow - 1, startCol, matrix);
                    break;
                case "down":
                    isDone = move(startRow, startCol, startRow + 1, startCol, matrix);
                    break;
                case "left":
                    isDone = move(startRow, startCol, startRow, startCol - 1, matrix);
                    break;
                case "right":
                    isDone = move(startRow, startCol, startRow, startCol + 1, matrix);
                    break;
            }
            if (isDone) {
                break;
            }
            if (neededBombs == bombs){
                break;
            }
        }
            if (bombs - neededBombs == 0){
                System.out.println("Congratulations! You found all bombs!");
            }
            else if (isDone){
                System.out.printf("END! %d bombs left on the field",bombs - neededBombs);
            }
            else {
                System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)"
                        ,bombs - neededBombs,startRow,startCol);
            }

    }

    private static boolean move(int beginRow, int beginCol, int newRow, int newCol, String[][] matrix) {
        matrix[beginRow][beginCol] = "+";
        if (outOfBounds(newRow,newCol,matrix)){
            newRow = beginRow;
            newCol = beginCol;
        }
            String symbol = matrix[newRow][newCol];
        if (symbol.equals("B")){
            System.out.println("You found a bomb!");
            neededBombs++;
        }
        else if (symbol.equals("e")){
            matrix[newRow][newCol] = "s";
           return true;
        }

        matrix[newRow][newCol] = "s";
        startRow = newRow;
        startCol = newCol;
       return false;
    }

    private static boolean outOfBounds(int newRow, int newCol, String[][] matrix) {
        return newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[newRow].length;
    }
}
