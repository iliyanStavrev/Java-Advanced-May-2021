package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

       List<Car>carList = new ArrayList<>();

        while (num-- > 0){
            String []tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            List<Tires>tiresList = new ArrayList<>();

            Tires tires = new Tires(Double.parseDouble(tokens[5]),Double.parseDouble(tokens[7]),
                    Double.parseDouble(tokens[9]),Double.parseDouble(tokens[11]),
                    Integer.parseInt(tokens[6]),Integer.parseInt(tokens[8]),
                    Integer.parseInt(tokens[12]),Integer.parseInt(tokens[10]));

              tiresList.add(tires);

              Car car = new Car(model,new Engine(engineSpeed,enginePower),
                      new Cargo(cargoWeight,cargoType),tiresList);

             carList.add(car);
        }
        String input = scanner.nextLine();

        List<String>model = new ArrayList<>();

        if (input.equals("fragile")){
            for (Car car : carList) {
                if ( car.getCargo().getCargoType().equals("fragile")){
                  if (car.getTires().get(0).pressure1 < 1 || car.getTires().get(0).pressure2 < 1
                  || car.getTires().get(0).pressure3 < 1 || car.getTires().get(0).pressure4 < 1){
                      model.add(car.model);
                  }
                }
            }
        }

        else if (input.equals("flamable")){
            for (Car car : carList) {
                if ( car.getCargo().getCargoType().equals("flamable")){
                    if (car.getEngine().getEnginePower() > 250){
                        model.add(car.model);
                    }
                }
            }
        }
        model.forEach(System.out::println);
    }
}
