import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String current = "";
        ArrayDeque<String>browser  = new ArrayDeque<>();
        while (!input.equals("Home")){
            if (input.equals("back")){
                if (!browser.isEmpty()){
                    current = browser.pop();
                }
                else {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            }
            else {
                if (!current.equals("")){
                    browser.push(current);
                }
                current = input;
            }
            System.out.println(current);
            input = scanner.nextLine();
        }
    }
}
