import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

         String input = "C:\\Users\\Iliyan\\Desktop\\input.txt";
        String output = "C:\\Users\\Iliyan\\Desktop\\02.WriteToFileOutput.txt";

        FileInputStream inputStream = new FileInputStream(input);
        FileOutputStream outputStream = new FileOutputStream(output);

        int oneByte = inputStream.read();

       PrintWriter writer = new PrintWriter(outputStream);

            Set<Character> punctuation = new HashSet<>();
            punctuation.add(',');
            punctuation.add('.');
            punctuation.add('!');
            punctuation.add('?');
            while (oneByte >= 0) {
                char symbol = (char) oneByte;
                if (!punctuation.contains(symbol)) {
                    writer.print(symbol);
                }

                oneByte = inputStream.read();
            }
            writer.close();
        inputStream.close();
        }
    }

