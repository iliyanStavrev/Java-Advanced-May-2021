package FroggyExercise;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[]stones = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        Lake lake = new Lake(stones);

       Iterator<Integer>froggy =  lake.iterator();

        String input = scanner.nextLine();

        List<String>out = new ArrayList<>();
        if (input.equals("END")){
            while (froggy.hasNext()){
              out.add(froggy.next() + "");
            }
            System.out.println(String.join(", ",out));

        }

    }
}
