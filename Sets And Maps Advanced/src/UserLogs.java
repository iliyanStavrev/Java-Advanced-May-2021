import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String,Map<String,Integer>>infoIp = new TreeMap<>();

        while (!input.equals("end")){
            String []tokens = input.split("\\s+");
            String ip = tokens[0].substring(3);
            String userName = tokens[2].substring(5);

            infoIp.putIfAbsent(userName,new LinkedHashMap<>());
            infoIp.get(userName).putIfAbsent(ip,0);
           infoIp.get(userName).put(ip,infoIp.get(userName).get(ip) + 1);


            input = scanner.nextLine();
        }
        infoIp.entrySet().stream()
                .forEach(e ->{
                    System.out.printf("%s: %n",e.getKey());
                    int size = e.getValue().size();
                    for (Map.Entry<String, Integer> i :e.getValue().entrySet()) {
                        if (size-- > 1){
                            System.out.printf("%s => %d, ",i.getKey(),i.getValue());
                        }
                        else {
                            System.out.printf("%s => %d.%n",i.getKey(),i.getValue());
                        }
                    }
                });
    }
}
