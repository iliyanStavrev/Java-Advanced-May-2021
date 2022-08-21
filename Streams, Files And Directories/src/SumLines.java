import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) throws IOException {

         String input = "C:\\Users\\Iliyan\\Desktop\\input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(input));

        String line = reader.readLine();

        while (line != null){
            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }

            System.out.println(sum);

            line = reader.readLine();
        }
    }
}
