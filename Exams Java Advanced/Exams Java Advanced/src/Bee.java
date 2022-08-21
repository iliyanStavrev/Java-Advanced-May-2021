import java.util.Scanner;

public class Bee {
   public static int startRow = 0;
          static int startCol = 0;
          static int flowers = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      int num = Integer.parseInt(scanner.nextLine());
      char[][]matrix = new char[num][num];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B'){
                    startRow = i;
                    startCol = j;
                }
            }
        }
        String command = scanner.nextLine();
        boolean isNotLost = true;

        while (!command.equals("End")){
           switch (command){
               case "up":
                isNotLost = move(startRow,startCol,startRow - 1,startCol,matrix,command);
                   break;
               case "down":
                   isNotLost = move(startRow,startCol,startRow + 1,startCol,matrix,command);
                   break;
               case "left":
                   isNotLost = move(startRow,startCol,startRow ,startCol - 1,matrix,command);
                   break;
               case "right":
                   isNotLost = move(startRow,startCol,startRow,startCol + 1,matrix,command);
                   break;
           }
           if (!isNotLost){
               break;
           }
            command = scanner.nextLine();
        }
        if(!isNotLost){
            System.out.println("The bee got lost!");
        }
        if (flowers < 5){
            System.out.printf("The bee couldn't pollinate the flowers, " +
                    "she needed %d flowers more%n",5 - flowers);
        }
        else {
            System.out.printf("Great job, the bee manage to " +
                    "pollinate %d flowers!%n",flowers);
        }
       printMatrix(matrix);
    }
    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    private static boolean move(int beginRow, int beginCol, int newRow, int newCol,
                                char[][] matrix,String direction) {
        matrix[beginRow][beginCol] = '.';

      if (outOfBounds(newRow,newCol,matrix)) {
         return false;
      }
      char symbol = matrix[newRow][newCol];
      if (symbol == 'f'){
          matrix[newRow][newCol]  = 'B';
          flowers++;
      }
      else if (symbol == 'O'){
          switch (direction){
              case "up":
                  matrix[newRow][newCol]  = '.';
                 if (outOfBounds(newRow -1,newCol,matrix)){
                     return false;
                 }
                 else {
                     newRow = newRow - 1;
                     symbol = matrix[newRow][newCol];
                     getFlowers(newRow, newCol, matrix, symbol);
                 }
                  break;
              case "down":
                  matrix[newRow][newCol]  = '.';
                  if (outOfBounds(newRow + 1,newCol,matrix)){
                      return false;
                  }
                  else {
                      newRow = newRow + 1;
                      symbol = matrix[newRow][newCol];
                      getFlowers(newRow, newCol, matrix, symbol);
                  }
                  break;
              case "left":
                  matrix[newRow][newCol]  = '.';
                  if (outOfBounds(newRow,newCol - 1,matrix)){
                      return false;
                  }
                  else {
                      newCol = newCol - 1;
                      symbol = matrix[newRow][newCol];
                      getFlowers(newRow, newCol, matrix, symbol);
                  }
                  break;
              case "right":
                  matrix[newRow][newCol]  = '.';
                  if (outOfBounds(newRow,newCol + 1,matrix)){
                      return false;
                  }
                  else {
                      newCol = newCol + 1;
                      symbol = matrix[newRow][newCol];
                      getFlowers(newRow, newCol, matrix, symbol);
                  }
                  break;
          }
      }
      matrix[newRow][newCol] = 'B';
        startRow = newRow;
        startCol = newCol;
        return true;
    }
    public static void getFlowers(int newRow, int newCol, char[][] matrix, char symbol) {
        if (symbol == 'f') {
            matrix[newRow][newCol] = 'B';
            flowers++;
        }
    }
    private static boolean outOfBounds(int newRow, int newCol, char[][] matrix) {
      return newRow < 0 || newCol < 0 || newRow >= matrix.length
                  || newCol >= matrix[newRow].length;
    }
}
