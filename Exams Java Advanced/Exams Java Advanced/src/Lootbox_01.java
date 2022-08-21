import java.util.*;

public class Lootbox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[]first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[]second = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer>firstLoot = new ArrayDeque<>();
        ArrayDeque<Integer>secondLoot = new ArrayDeque<>();
        for (int i = 0; i < first.length; i++) {
            firstLoot.offer(first[i]);
        }
        for (int i = 0; i < second.length; i++) {
            secondLoot.push(second[i]);
        }
        List<Integer>claimed = new ArrayList<>();
        while (!firstLoot.isEmpty() && !secondLoot.isEmpty()){

            int sum = firstLoot.peek() + secondLoot.peek();
            if (sum % 2 == 0){
                firstLoot.poll();
                secondLoot.pop();
                claimed.add(sum);
            }
            else {
               firstLoot.offer(secondLoot.pop());
            }
        }
       if (firstLoot.isEmpty()){
           System.out.println("First lootbox is empty");
       }
       else {
           System.out.println("Second lootbox is empty");
       }
       int total = claimed.stream().
               mapToInt(Integer::intValue).sum();
       if (total >= 100){
           System.out.println("Your loot was epic! Value: " + total);
       }
       else {
           System.out.println("Your loot was poor... Value: " + total);
       }

    }
}
