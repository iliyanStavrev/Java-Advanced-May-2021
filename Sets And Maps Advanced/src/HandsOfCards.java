import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>>info = new LinkedHashMap<>();

        while (!input.equals("JOKER")){
          String []tokens = input.split(":\\s+");
          String name = tokens[0];
          List<String>cards = Arrays.stream(tokens[1].split(", "))
                  .collect(Collectors.toList());
      info.putIfAbsent(name,new HashSet<>());
      info.get(name).addAll(cards);

            input = scanner.nextLine();
        }
        info.forEach((k,value) ->{
            int sum = calculateSum(value);
            System.out.printf("%s: %d%n",k,sum);
        });
    }

    private static int calculateSum(Set<String> value) {
        int power = 0;
        for (String card : value) {
            power += calcCard(card);

        }
        return power;
    }

    private static int calcCard(String card) {
        int power = 0;
        int strength = 0;
        char first = card.charAt(0);
        if (Character.isDigit(first)){
            power = first - '0';
            if (Character.isDigit(card.charAt(1))){
                power = 10;
            }
        }
        else {
            switch (first){
                case 'J':
                    power = 11;
                    break;
                case 'Q':
                    power = 12;
                    break;
                case 'K':
                    power = 13;
                    break;
                case 'A':
                    power = 14;
                    break;
            }
        }

        char second = card.charAt(card.length() - 1);
        switch (second){
            case 'C':
                strength = 1;
                break;
            case 'D':
                strength = 2;
                break;
            case 'H':
                strength = 3;
                break;
            case 'S':
                strength = 4;
                break;

        }
        return power * strength;
    }
}
