import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       List<String> guestList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
       List<String>guestDeleted = new ArrayList<>();

       String input = scanner.nextLine();

       while (!input.equals("Print")){

           String []tokens = input.split(";");

           String command = tokens[0];
           String filterType = tokens[1];
           String filterParameter = tokens[2];

           if (command.equals("Add filter")){
               for (int i = 0; i < guestList.size(); i++) {
                   String guest = guestList.get(i);
                   if (getPredicate(filterType,filterParameter).test(guest)){
                       guestDeleted.add(guest);
                   }
               }
                  guestList.removeIf(getPredicate(filterType,filterParameter));

          }
           else if (command.equals("Remove filter")){
               for (int i = 0; i < guestDeleted.size(); i++) {
                   String guest = guestDeleted.get(i);
                   if (getPredicate(filterType,filterParameter).test(guest)){
                       guestList.add(0,guest);
                   }
               }
               guestDeleted.removeIf(getPredicate(filterType,filterParameter));
           }

           input = scanner.nextLine();
       }
        System.out.println(String.join(" ", guestList));
    }

    private static Predicate<String> getPredicate(String filterType, String filterParameter) {
        switch (filterType){
            case "Starts with": return text -> text.startsWith(filterParameter);

            case "Ends with": return text -> text.endsWith(filterParameter);

            case "Length": return text -> text.length() == Integer.parseInt(filterParameter);

            case "Contains": return text -> text.contains(filterParameter);

        }
        return text -> false;
    }
}
