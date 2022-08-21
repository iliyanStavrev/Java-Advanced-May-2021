import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(?<singer>([a-zA-Z]+\\s){1,3})" +
                "@(?<venue>([a-zA-Z]+\\s){1,3})(?<tickets>\\d+)\\s(?<price>\\d+)";

        String input = scanner.nextLine();

        Map<String,Map<String,Integer>>infoSinger = new LinkedHashMap<>();

        while (!input.equals("End")){
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            String singer = "";
            String venue = "";
            int tickets = 0;
            int price = 0;
            if (matcher.find()){
              singer = matcher.group("singer");
              venue = matcher.group("venue");
              tickets = Integer.parseInt(matcher.group("tickets"));
              price = Integer.parseInt(matcher.group("price"));

              infoSinger.putIfAbsent(venue,new TreeMap<>());
              infoSinger.get(venue).putIfAbsent(singer,0);
              infoSinger.get(venue).put(singer,infoSinger.get(venue).get(singer) + tickets * price);
            }

            input = scanner.nextLine();
        }
        infoSinger.entrySet().stream()
                .forEach(s ->{
                    System.out.printf("%s%n",s.getKey());
                    s.getValue().entrySet().stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach(e ->
                                    System.out.printf("#  %s-> %d%n",e.getKey(),e.getValue()));
                });
    }
}
