import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {


        int size = (int) Files.size(Path.of("C:\\Users\\Iliyan\\Desktop\\Exercises Resources"));
        System.out.println("Folder size: " + size);
    }
}
