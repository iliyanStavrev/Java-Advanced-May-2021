import java.util.ArrayDeque;
import java.util.Scanner;

public class Bomb_01_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[]input = scanner.nextLine().split(",\\s+");
        String[]input1 = scanner.nextLine().split(",\\s+");

        ArrayDeque<Integer>effects = new ArrayDeque<>();
        ArrayDeque<Integer>casings = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            effects.add(Integer.parseInt(input[i]));
        }
        for (int i = 0; i < input1.length; i++) {
            casings.push(Integer.parseInt(input1[i]));
        }
        int datura = 0;
        int cherry = 0;
        int smoke = 0;
        boolean isEnough = false;
        while (!effects.isEmpty() && !casings.isEmpty()){
            int sum = effects.poll() + casings.pop();

            while (sum >= 35){
                if (sum == 40){
                    datura++;
                    break;
                }
                else if (sum == 60){
                    cherry++;
                    break;
                }
                else if (sum == 120){
                    smoke++;
                    break;
                }
                else {
                    sum -= 5;
                }
            }
            if (datura >= 3 && cherry >= 3 && smoke >= 3){
                isEnough = true;
                break;
            }
        }
        if (isEnough){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }
        else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (effects.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }
        else {
            System.out.println("Bomb Effects: " + effects.toString().replaceAll("[\\[\\]]",""));
        }
        if (casings.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }
        else {
            System.out.println("Bomb Casings: " + casings.toString().replaceAll("[\\[\\]]",""));
        }
        System.out.printf("Cherry Bombs: %d%n" +
                "Datura Bombs: %d%n" +
                "Smoke Decoy Bombs: %d",cherry,datura,smoke);
    }
}
