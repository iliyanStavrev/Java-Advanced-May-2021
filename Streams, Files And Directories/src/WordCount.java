import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\Iliyan\\Desktop\\text.txt";
        String inputList = "C:\\Users\\Iliyan\\Desktop\\words.txt";
        String output = "C:\\Users\\Iliyan\\Desktop\\output.txt";

        BufferedReader reader = new BufferedReader(new FileReader(input));
        BufferedReader readerList = new BufferedReader(new FileReader(inputList));
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));

        String[] words = readerList.readLine().split("\\s+");

        String [] text = reader.readLine().split("[\\s,.:;!?]+");

        Map<String,Integer>sequence = new LinkedHashMap<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < text.length; j++) {

                if (words[i].equals(text[j])){
               sequence.putIfAbsent(words[i],0);
               sequence.put(words[i],sequence.get(words[i]) + 1);
                }
            }
        }
        sequence.entrySet()
                .forEach(e -> {
                    try {
                        writer.write(e.getKey() + " - " + e.getValue() + "\n");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                });
        writer.close();
    }
}
