import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\Iliyan\\Desktop\\input.txt";
        String output = "C:\\Users\\Iliyan\\Desktop\\output.txt";

        FileInputStream inputStream = new FileInputStream(input);
        PrintWriter writer = new PrintWriter(output);

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext()){

            if (scanner.hasNextInt()){
                int number = scanner.nextInt();
                writer.print(String.valueOf(number));
                writer.write(System.lineSeparator());
            }
                scanner.next();

        }
        writer.flush();
    }
}
