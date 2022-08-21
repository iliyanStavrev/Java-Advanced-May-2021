import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,Integer>userTime = new TreeMap<>();
        Map<String,Set<String>>ipUsers = new TreeMap<>();


        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[]tokens = input.split("\\s+");
            String ip = tokens[0];
            String user = tokens[1];
            int time = Integer.parseInt(tokens[2]);

            userTime.putIfAbsent(user,0);
            userTime.put(user,userTime.get(user) + time);

            ipUsers.putIfAbsent(user,new TreeSet<>());
            ipUsers.get(user).add(ip);

        }

        userTime.entrySet()
                .forEach(e ->
                    System.out.printf("%s: %d %s%n",
                            e.getKey(),e.getValue(),ipUsers.get(e.getKey())));

    }
}
