import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {


        String input = "C:\\Users\\Iliyan\\Desktop\\input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(input));

        String line = reader.readLine();

        long total = 0;

        while (line != null){

            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }

            total += sum;
            line = reader.readLine();
        }
        System.out.println(total);
    }
}
