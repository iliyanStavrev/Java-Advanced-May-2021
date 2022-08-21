import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        Map<Character,Integer>charSequence = new TreeMap<>();

        for (int i = 0; i < string.length(); i++) {
            char current = string.charAt(i);
            charSequence.putIfAbsent(current,0);
            charSequence.put(current,charSequence.get(current) + 1);
        }
        charSequence.entrySet().stream()
                .forEach(e -> System.out.printf("%c: %d time/s%n",e.getKey(),e.getValue()));
    }
}
