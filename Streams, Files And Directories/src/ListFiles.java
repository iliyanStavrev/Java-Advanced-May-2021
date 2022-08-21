import java.io.File;
import java.io.IOException;

public class ListFiles {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\Iliyan\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(input);

        File[] innerFiles = file.listFiles();


        for (File innerfile : innerFiles) {
         if (!innerfile.isDirectory()){
             System.out.printf("%s: [%d]%n",innerfile.getName(),innerfile.length());
         }
        }

    }
}
