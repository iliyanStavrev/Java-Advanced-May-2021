import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());

        String [][]first = new String[row][col];
        String [][]second = new String[row][col];
        for (int i = 0; i < row; i++) {
            String[]arr = scanner.nextLine().split("\\s+");
            first[i] = arr;
        }
        for (int i = 0; i < row; i++) {
            String[]arr = scanner.nextLine().split("\\s+");
            second[i] = arr;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < first[i].length; j++) {
                if (!first[i][j].equals(second[i][j])){
                    System.out.print("* ");
                }
                else {
                    System.out.print(first[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
