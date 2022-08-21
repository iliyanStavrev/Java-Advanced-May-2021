import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String>parking = new LinkedHashSet<>();

        while (!input.equals("END")){
            String[]tokens = input.split(",\\s+");
            String directions = tokens[0];
            String registration = tokens[1];
            if (directions.equals("IN")){
                parking.add(registration);
            }
            else if (directions.equals("OUT")){
                parking.remove(registration);
            }
             input = scanner.nextLine();
        } String output;
        if (parking.size() > 0){
            output = parking.stream().
                    collect(Collectors.joining(System.lineSeparator()));
        }
        else {
            output = "Parking Lot is Empty";
        }
        System.out.println(output);
    }
}
