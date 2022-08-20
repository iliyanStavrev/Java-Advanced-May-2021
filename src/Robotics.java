import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String>robotsInfo = Arrays.stream(scanner.nextLine().split(";"))
                .collect(Collectors.toList());
       String[]names = new String[robotsInfo.size()];
       int [] processTime = new int[robotsInfo.size()];
        for (int i = 0; i < robotsInfo.size(); i++) {
            String[]tokens = robotsInfo.get(i).split("-");
         names[i] = tokens[0];
         processTime[i] = Integer.parseInt(tokens[1]);
        }
        String startingTime = scanner.nextLine();
        String []tokens = startingTime.split(":");
        int hours = Integer.parseInt(tokens[0]);
        int minutes = Integer.parseInt(tokens[1]);
        int seconds = Integer.parseInt(tokens[2]);

        int beginTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        ArrayDeque<String>productsQueue = new ArrayDeque<>();
        String products = scanner.nextLine();
        while (!products.equals("End")){
           productsQueue.offer(products);

            products = scanner.nextLine();
        }
        int []robotsLeft = new int[names.length];
        while (!productsQueue.isEmpty()){
            beginTimeInSeconds++;
            String product = productsQueue.poll();
            int index = -1;

            for (int i = 0; i < robotsLeft.length; i++) {
                if (robotsLeft[i] > 0){
                    robotsLeft[i] --;
                }
           if (robotsLeft[i] == 0 && index == -1){
               index = i;
           }
            }

            if (index != -1){
                robotsLeft[index] = processTime[index];
                System.out.println(printRobotData(names[index],product,beginTimeInSeconds));
            }
            else {
                productsQueue.offer(product);
            }

        }

    }

    private static String printRobotData(String name, String product, int beginTimeInSeconds) {
        int hours = (beginTimeInSeconds / 3600) % 24;
        int minutes = (beginTimeInSeconds / 60 ) % 60;
        int seconds = beginTimeInSeconds % 60;
         String time = String.format("%02d:%02d:%02d",hours,minutes,seconds);
        return String.format("%s - %s [%s]",name,product,time);
    }
}
