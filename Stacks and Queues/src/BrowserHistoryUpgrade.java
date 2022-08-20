import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String>forward = new ArrayDeque<>();
        ArrayDeque<String>backward = new ArrayDeque<>();

        while (!input.equals("Home")){
            if (input.equals("forward")){
            if (forward.isEmpty()){
                System.out.println("no next URLs");
            }
            else {
                System.out.println(forward.peek());
                backward.push(forward.poll());
            }
            }
            else if (input.equals("back")){
              if (backward.size() < 2){
                  System.out.println("no previous URLs");
              }
              else {
                  forward.addFirst(backward.pop());
                  System.out.println(backward.peek());

              }
            }
            else {
                System.out.println(input);
                backward.push(input);
                forward.clear();
            }

            input = scanner.nextLine();
        }
    }
}
