import java.util.*;

public class Bombs_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer>effects = new ArrayDeque<>();
        String[]input = scanner.nextLine().split(", ");
        for (int i = 0; i < input.length; i++) {
            effects.offer(Integer.parseInt(input[i]));
        }
        ArrayDeque<Integer>casing = new ArrayDeque<>();
        String[]input1 = scanner.nextLine().split(", ");
        for (int i = 0; i < input1.length; i++) {
            casing.push(Integer.parseInt(input1[i]));
        }
        Map<String,Integer>bombPouch = new TreeMap<>();
        Map<String,Integer>bombs = new LinkedHashMap<>();
        bombs.put("Datura Bombs",40);
        bombs.put("Cherry Bombs",60);
        bombs.put("Smoke Decoy Bombs",120);
        bombPouch.put("Cherry Bombs",0);
        bombPouch.put("Datura Bombs",0);
        bombPouch.put("Smoke Decoy Bombs",0);

        int datura = 0;
        int cherry = 0;
        int smoke = 0;
        boolean allBombsFind = false;
        while (!effects.isEmpty() && !casing.isEmpty()){
            int sum = effects.poll() + casing.pop();
          while (true){
              if (sum <= 35){
                  break;
              }
              String name = equalBombs(bombs,sum);
              if (name == null){
                  sum -= 5;
                  continue;
              }

              bombPouch.put(name,bombPouch.get(name) + 1);
              if (sum == 40){
                  datura++;
                  break;
              }else if (sum == 60){
                  cherry++;
                  break;
              }
              else if (sum == 120){
                  smoke++;
                  break;
              }
          }
          if (datura >= 3 && cherry >= 3 && smoke >= 3){
              allBombsFind = true;
              break;
          }
            }
        if (!allBombsFind){
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        else {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }
        if (effects.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }
        else {

            System.out.print("Bomb Effects: ");
            System.out.println(String.join(", ",effects + "").
                    replaceAll("[\\[\\]]",""));
        }
        if (casing.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }
        else {
            System.out.print("Bomb Casings: ");
            System.out.println(String.join(", ", casing + "").
                    replaceAll("[\\[\\]]",""));
        }
        bombPouch.entrySet().
                forEach(e ->
                        System.out.printf("%s: %d%n",e.getKey(),e.getValue()));
        }


    private static String equalBombs(Map<String, Integer> bombs, int sum) {
        for (Map.Entry<String, Integer> entry : bombs.entrySet()) {
            if (entry.getValue() == sum){
                return entry.getKey();
            }
        }
        return null;
    }
}
