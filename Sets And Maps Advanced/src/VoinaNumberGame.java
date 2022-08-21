import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstDeck = Arrays.stream(scanner.nextLine().
                split("\\s++")).map(Integer::parseInt).
        collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondDeck = Arrays.stream(scanner.nextLine().
                split("\\s++")).map(Integer::parseInt).
                collect(Collectors.toCollection(LinkedHashSet::new));


        int rounds = 50;
        while (rounds -- > 0 || firstDeck.isEmpty() || secondDeck.isEmpty()){

            int firstNumber = firstDeck.iterator().next();
            firstDeck.remove(firstNumber);
            int secondNumber = secondDeck.iterator().next();
            secondDeck.remove(secondNumber);

            if (firstNumber > secondNumber){
                firstDeck.add(firstNumber);
                firstDeck.add(secondNumber);
            }
            else if (secondNumber > firstNumber){
                secondDeck.add(firstNumber);
                secondDeck.add(secondNumber);
            }
        }
        if (firstDeck.size() < secondDeck.size()){
            System.out.println("Second player win!");
        }
        else if (secondDeck.size() < firstDeck.size()){
            System.out.println("First player win!");
        }
        else {
            System.out.println("Draw!");
        }
    }
}
