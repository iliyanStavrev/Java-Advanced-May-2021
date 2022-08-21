import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[]first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[]second = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer>males = new ArrayDeque<>();
        ArrayDeque<Integer>females = new ArrayDeque<>();

        for (int i = 0; i < first.length; i++) {
            males.push(first[i]);
        }
        for (int i = 0; i < second.length; i++) {
            females.add(second[i]);
        }
        int matches = 0;
        while (!males.isEmpty() && !females.isEmpty()){
            if (males.peek() <= 0){
                males.pop();
            }
            if (females.peek() <= 0){
                females.poll();
            }
            if (males.peek() % 25 == 0 || females.peek() % 25 == 0){
                if (males.peek() % 25 == 0){
                    if (males.size() > 1){
                        males.pop();
                        males.pop();
                    }
                    else {
                        males.pop();
                    }
                }
                else {
                    if (females.size() > 1){
                        females.pop();
                        females.pop();
                    }
                    else {
                        females.pop();
                    }
                }
                continue;
            }
            if (males.peek() == females.peek()){
                matches++;
                males.pop();
                females.poll();
            }
            else {
                int male = males.pop() - 2;
                if (male > 0){
                    males.push(male);
                }

                females.poll();
            }
        }
        System.out.printf("Matches: %d%n",matches);
        if (males.isEmpty()){
            System.out.println("Males left: none");
        }
        else {
            System.out.println("Males left: " + males.toString().replaceAll("[\\[\\]]",""));
        }
        if (females.isEmpty()){
            System.out.println("Females left: none");
        }
        else {
            System.out.println("Females left: " + females.toString().replaceAll("[\\[\\]]",""));
        }

    }
}
