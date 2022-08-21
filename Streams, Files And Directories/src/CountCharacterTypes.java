import java.io.*;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\Iliyan\\Desktop\\input.txt";
        String output = "C:\\Users\\Iliyan\\Desktop\\output.txt";

        BufferedReader reader = new BufferedReader(new FileReader(input));

        BufferedWriter writer = new BufferedWriter(new FileWriter(output));

        String line = reader.readLine();
        int vowels = 0;
        int punctuation = 0;
        int consonants = 0;
        while (line != null){

            for (int i = 0; i < line.length(); i++) {
           char current = line.charAt(i);
                if (current == 'a' || current == 'e' || current == 'i'
                        || current == 'o' || current == 'u'){

                    vowels++;
                }
                else if (current == '!' || current == ','
                        || current== '.' || current == '?'){

                    punctuation ++;
                }
                else if (current == 32){

                }
                else {
                    consonants ++;
                }
            }
            line = reader.readLine();
        }

       writer.write("Vowels: " + vowels + "\n");
        writer.write("Consonants: " + consonants + "\n");
        writer.write("Punctuation: " + punctuation +"\n");

        writer.close();
    }
}
