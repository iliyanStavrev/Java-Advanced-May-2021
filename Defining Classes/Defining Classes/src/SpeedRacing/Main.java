package SpeedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());


        List<Car>carList = new ArrayList<>();

        while (num -- > 0){
            String []tokens = scanner.nextLine().split("\\s+");
            String model= tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostForKm = Double.parseDouble(tokens[2]);

            Car car = new Car(model,fuelAmount,fuelCostForKm);
           carList.add(car);
        }
        String input = scanner.nextLine();

        while (!input.equals("End")){
            String[]tokens = input.split("\\s+");
             String model = tokens[1];
             int amountOfKm = Integer.parseInt(tokens[2]);

            for (Car car1 : carList) {
               if (model.equals(car1.getModel())){
                   car1.Drive(amountOfKm);
               }
            }
            input = scanner.nextLine();
        }
        for (Car car1 : carList) {
            System.out.printf("%s %.2f %d%n",car1.getModel(),
                    car1.getFuelAmount(),car1.getDistanceTraveled());
        }
    }
}

