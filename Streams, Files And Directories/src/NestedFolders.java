import java.io.File;

public class NestedFolders {

    public static int folderCount = 0;

    public static void main(String[] args) {

        String input = "C:\\Users\\Iliyan\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(input);
        
        dfs(file);

        System.out.println("[" + folderCount + "] folders");
        
    }

    private static void dfs(File file) {
        folderCount ++;

        for (File f: file.listFiles()) {
             if (f.isDirectory()){

                 dfs(f);
             }
        }
        System.out.println(file.getName());
    }
}
