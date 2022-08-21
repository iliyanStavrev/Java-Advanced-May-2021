import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "C:\\Users\\Iliyan\\Desktop\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int oneByte = inputStream.read();

        while (oneByte >= 0){

            System.out.printf("%s ",Integer.toBinaryString(oneByte));
            oneByte = inputStream.read();
        }
    }
}
