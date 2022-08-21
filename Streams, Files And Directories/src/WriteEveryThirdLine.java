import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\Iliyan\\Desktop\\input.txt";
        String output = "C:\\Users\\Iliyan\\Desktop\\output.txt";

        BufferedReader reader = new BufferedReader(new FileReader(input));

        BufferedWriter writer = new BufferedWriter(new FileWriter(output));

        String line = reader.readLine();

        int numberLine = 0;
        while (line != null){
            numberLine ++;

            if (numberLine % 3 == 0){

                writer.write(line);
                writer.newLine();
            }

            line = reader.readLine();
        }
        writer.close();
    }
}
