import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOperations = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String>operations = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < numOperations; i++) {
            String commands = scanner.nextLine();
            String [] tokens = commands.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "1":
                   text.append(tokens[1]);
                   operations.push(text.toString());
                    break;
                case "2":
                    int numberToErase = Integer.parseInt(tokens[1]);
                    text.replace(text.length() - numberToErase,text.length(),"");
                    operations.push(text.toString());
                    break;
                case "3":
                    int indexToPrint = Integer.parseInt(tokens[1]);
                    System.out.println(text.charAt(indexToPrint - 1));
                    break;
                case "4":
                    operations.poll();
                   text =  new StringBuilder(operations.getFirst());
                    break;
            }
        }
    }
}
