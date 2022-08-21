import java.io.*;

public class ALLCAPITALS {
    public static void main(String[] args) throws IOException {


        String input = "C:\\Users\\Iliyan\\Desktop\\input.txt";
        String output = "C:\\Users\\Iliyan\\Desktop\\output.txt";

        BufferedReader reader = new BufferedReader(new FileReader(input));

        BufferedWriter writer = new BufferedWriter(new FileWriter(output));

        String line = reader.readLine();

        while (line != null){

          String current = line.toUpperCase();

           writer.write(current);
           writer.newLine();

            line = reader.readLine();
        }
        writer.close();
    }
}
