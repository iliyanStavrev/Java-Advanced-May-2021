import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] tokens = scanner.nextLine().split("\\s+");
        int r = Integer.parseInt(tokens[0]);
        int c = Integer.parseInt(tokens[1]);
        String [][]matrix = new String[r][c];
        char a = 'a';
        char b = 'a';

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                String output = (char)a +""+ (char)b + (char)a;
                matrix[i][j] = output;
                System.out.print(output + " ");
                b++;
            }
            a++;
            b = a;
            System.out.println();
        }
    }
}
