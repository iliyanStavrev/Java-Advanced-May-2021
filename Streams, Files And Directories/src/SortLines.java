import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\Iliyan\\Desktop\\input.txt";
        String output = "C:\\Users\\Iliyan\\Desktop\\output.txt";

        List<String> lines = Files.readAllLines(Paths.get(input))
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        Files.write(Paths.get(output),lines, Charset.defaultCharset());

    }
}
