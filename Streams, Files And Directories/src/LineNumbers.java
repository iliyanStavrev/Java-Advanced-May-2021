import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {


        String input = "C:\\Users\\Iliyan\\Desktop\\inputLineNumbers.txt";

        String output = "C:\\Users\\Iliyan\\Desktop\\output.txt";

        BufferedReader reader = new BufferedReader(new FileReader(input));

        BufferedWriter printer = new BufferedWriter(new FileWriter(output));

        String line = reader.readLine();

        int count = 0;
        while (line != null){
            count ++;
            printer.write(count + ". " + line + "\n");

            line = reader.readLine();
        }
        printer.close();
    }
}
