import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\Iliyan\\Desktop\\input.txt";
        String output = "C:\\Users\\Iliyan\\Desktop\\output.txt";

        FileInputStream inputStream = new FileInputStream(input);

        FileOutputStream outputStream = new FileOutputStream(output);

       PrintWriter writer = new PrintWriter(outputStream);

        int onebyte = inputStream.read();

        while (onebyte >= 0){


                if (onebyte == 10 || onebyte == 32){
                    writer.print((char)onebyte);
                }
                else {
          writer.print(onebyte);
                    }
            onebyte = inputStream.read();
                }

        }
    }

