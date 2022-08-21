import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;


public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


   int [][]firstMatrix = readMatrix(scanner);
   int [][]secondMatrix = readMatrix(scanner);

   boolean isEqual = true;
   if (firstMatrix.length != secondMatrix.length){
      isEqual = false;
   }else {
       for (int i = 0; i < firstMatrix.length; i++) {
           int [] firstArr = firstMatrix[i];
           int [] secondArr = secondMatrix[i];
           if (firstArr.length != secondArr.length){
               isEqual = false;
               break;
           }
           for (int j = 0; j < firstArr.length; j++) {
               if (firstMatrix[i][j] != secondMatrix[i][j]){
                   isEqual = false;
                   break;
               }
           }
           if (!isEqual){
               break;
           }
       }
   }
   String output = isEqual ? "equal" : "not equal";
        System.out.println(output);
    }

    private static int[][] readMatrix(Scanner scanner) {
        int [] input = read(scanner);
        int rows = input[0];
        int cols = input[1];

        int [][]matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = read(scanner);
        }
        return matrix;
    }

    private static int[] read(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

}
