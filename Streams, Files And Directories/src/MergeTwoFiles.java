import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {



        String data1 = Files.readString(Path.of("C:\\Users\\Iliyan\\Desktop\\inputOne.txt"));
        String data2 = Files.readString(Path.of("C:\\Users\\Iliyan\\Desktop\\inputTwo.txt"));

        String output = "C:\\Users\\Iliyan\\Desktop\\output.txt";

        BufferedWriter writer1 = new BufferedWriter(new FileWriter(output));

        writer1.write(data1 + "\n");
        writer1.write(data2);

        writer1.close();

    }
}
