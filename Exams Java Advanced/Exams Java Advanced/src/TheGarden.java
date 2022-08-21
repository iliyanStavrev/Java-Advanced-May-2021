import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numRow = Integer.parseInt(scanner.nextLine());

        String[][]matrix = new String[numRow][];
        int lettuce = 0;
        int potatoes = 0;
        int carrots = 0;
        int harmed = 0;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
        String commands = scanner.nextLine();

        while (!commands.equals("End of Harvest")){
            String[]tokens = commands.split("\\s+");
            String command = tokens[0];
            switch (command){
                case "Harvest":
                    int row = Integer.parseInt(tokens[1]);
                    int col = Integer.parseInt(tokens[2]);
                    if (outOfBounds(row,col,matrix)){
                        commands = scanner.nextLine();
                        continue;
                    }
                    if (matrix[row][col].equals("L")){
                       lettuce++;
                    }
                   else if (matrix[row][col].equals("P")){
                        potatoes++;
                    }
                    else if (matrix[row][col].equals("C")){
                       carrots++;
                    }
                    matrix[row][col] = " ";
                    break;
                case "Mole":
                    row = Integer.parseInt(tokens[1]);
                    col = Integer.parseInt(tokens[2]);
                    String direction = tokens[3];
                    switch (direction){
                        case "up":
                            while (!outOfBounds(row,col,matrix)){
                                if (Character.isLetter(matrix[row][col].charAt(0))){
                                    harmed++;
                                }
                                matrix[row][col] = " ";
                                row -= 2;
                            }
                            break;
                        case "down":
                            while (!outOfBounds(row,col,matrix)){
                                if (Character.isLetter(matrix[row][col].charAt(0))){
                                    harmed++;
                                }
                                matrix[row][col] = " ";
                                row += 2;
                            }
                            break;
                        case "left":
                            while (!outOfBounds(row,col,matrix)){
                                if (Character.isLetter(matrix[row][col].charAt(0))){
                                    harmed++;
                                }
                                matrix[row][col] = " ";
                                col -= 2;
                            }
                            break;
                        case "right":
                            while (!outOfBounds(row,col,matrix)){
                                if (Character.isLetter(matrix[row][col].charAt(0))){
                                    harmed++;
                                }
                                matrix[row][col] = " ";
                                col += 2;
                            }
                            break;
                    }
                    break;
            }
            commands = scanner.nextLine();
        }
        print(matrix);
        System.out.println("Carrots: " + carrots);
        System.out.println("Potatoes: " + potatoes);
        System.out.println("Lettuce: " + lettuce);
        System.out.println("Harmed vegetables: " + harmed);
    }

    private static boolean outOfBounds(int row, int col, String[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void print(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
