import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FlowerWreaths_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer>lilies = new ArrayDeque<>();
        ArrayDeque<Integer>roses = new ArrayDeque<>();

        String[]input = scanner.nextLine().split(", ");
        for (int i = 0; i < input.length; i++) {
            lilies.push(Integer.parseInt(input[i]));
        }
        String[]input1 = scanner.nextLine().split(", ");
        for (int i = 0; i < input1.length; i++) {
            roses.offer(Integer.parseInt(input1[i]));
        }
       int wreaths = 0;
        List<Integer>storeSum = new ArrayList<>();

        while (!lilies.isEmpty() && !roses.isEmpty()){

            int liliValue = lilies.pop();
            int roseValue = roses.poll();

            int sum = liliValue + roseValue;

            if (sum == 15){
                wreaths++;
            }
            else if(sum > 15){
                while (true){
                    sum = sum -2;
                    if (sum == 15){
                        wreaths++;
                        break;
                    }
                    else if (sum < 15){
                        storeSum.add(sum);
                        break;
                    }
                }
            }
           else   if (sum < 15){
                storeSum.add(sum);
            }
        }

       int totalSumLeft =  storeSum.stream()
                .mapToInt(Integer::intValue)
                .sum();

        wreaths += totalSumLeft / 15;
        if (wreaths >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!",wreaths);
        }
        else {
            System.out.printf("You didn't make it, you need %d wreaths more!",5 - wreaths);
        }

    }
}
