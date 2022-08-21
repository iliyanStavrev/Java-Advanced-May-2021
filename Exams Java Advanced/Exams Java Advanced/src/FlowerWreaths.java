import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        ArrayDeque<Integer>roses = new ArrayDeque<>();

        String[]input1 = scanner.nextLine().split(", ");
        for (int i = 0; i < input1.length; i++) {
            lilies.push(Integer.parseInt(input1[i]));
        }
        String[]input2 = scanner.nextLine().split(", ");
        for (int i = 0; i < input2.length; i++) {
            roses.offer(Integer.parseInt(input2[i]));
        }
        int wreaths = 0;

        List<Integer>stored = new ArrayList<>();

        while (!lilies.isEmpty() && !roses.isEmpty()){
            int lili = lilies.peek();
            int rose = roses.peek();

           int sum = lilies.pop() + roses.poll();
         if (sum > 15){
             lilies.push(lili - 2);
             roses.addFirst(rose);
         }
         else if (sum == 15){
             wreaths++;
         }
         else {
             stored.add(sum);
         }
        }
      int total = stored.stream().mapToInt(Integer::intValue).sum();
      wreaths += total / 15;

      if (wreaths >= 5){
          System.out.printf("You made it, you are going to the competition with %d wreaths!",wreaths);
      }
      else {
          System.out.printf("You didn't make it, you need %d wreaths more!",5 - wreaths);
      }
    }
}
