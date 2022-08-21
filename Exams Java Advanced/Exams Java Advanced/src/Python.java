import java.util.Scanner;

public class Python {
    static int startRow = 0;
    static int startCol = 0;
    static int foodNeeded = 1;
    static int length = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String[]tokens = scanner.nextLine().split(",\\s+");

        String[][]matrix = new String[num][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("s")) {
                    startRow = i;
                    startCol = j;
                }
                else if (matrix[i][j].equals("f")){
                    foodNeeded++;
                }
            }
        }
            boolean isKilled = false;
        for (int i = 0; i < tokens.length; i++) {
            String command = tokens[i];
            switch (command){
                case "up":
                isKilled = move(startRow,startCol,startRow - 1,startCol,matrix);
                    break;
                case "down":
                    isKilled = move(startRow,startCol,startRow + 1,startCol,matrix);
                    break;
                case "left":
                    isKilled = move(startRow,startCol,startRow,startCol - 1,matrix);
                    break;
                case "right":
                    isKilled = move(startRow,startCol,startRow,startCol + 1,matrix);
                    break;

            }
            if (isKilled){
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
            if (foodNeeded == length){
                System.out.println("You win! Final python length is " + length);
                return;
            }
        }
        System.out.printf("You lose! There is still %d food to be eaten.",foodNeeded - length);

    }

    private static boolean move(int beginRow, int beginCol, int newRow, int newCol, String[][] matrix) {

        matrix[beginRow][beginCol] = "*";
        if (newRow < 0){
            newRow = matrix.length - 1;
        }
        else if (newRow >= matrix.length){
            newRow = 0;
        }
        else if (newCol < 0){
            newCol = matrix[newRow].length - 1;
        }
        else if (newCol >= matrix[newRow].length){
            newCol = 0;
        }
        String symbol = matrix[newRow][newCol];
        if (symbol.equals("f")){
            length ++;
        }
        else if (symbol.equals("e")){
            return true;
        }
        matrix[newRow][newCol] = "s";
        startRow = newRow;
        startCol = newCol;
        return false;
    }
}
