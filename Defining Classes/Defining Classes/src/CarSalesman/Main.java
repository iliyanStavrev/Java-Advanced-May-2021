package CarSalesman;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        List<Engine>engineList = new ArrayList<>();

             while (num-- > 0){
         String[] tokens = scanner.nextLine().split("\\s+");
         String engineModel = tokens[0];
         String power = tokens[1];
         String displacement = "n/a";
         String efficiency = "n/a";

         switch (tokens.length){
             case 3:
                 if (Character.isDigit(tokens[2].charAt(0))){
                     displacement = tokens[2];
                 }
                 else {
                     efficiency = tokens[2];
                 }
                 break;
             case 4:
                 if (Character.isDigit(tokens[2].charAt(0))){
                     displacement = tokens[2];
                     efficiency = tokens[3];
                 }
                 else {
                     efficiency = tokens[2];
                     displacement = tokens[3];
                 }
                 break;
         }
         Engine engine = new Engine(engineModel,power,displacement,efficiency);
         engineList.add(engine);
     }

        List<Car>carList = new ArrayList<>();


             num = Integer.parseInt(scanner.nextLine());
             while (num -- > 0){
                 List<Engine>exactEngine = new ArrayList<>();
                String []tokens = scanner.nextLine().split("\\s+");
                String carModel = tokens[0];
                String engineModel = tokens[1];
                String weight = "n/a";
                String color = "n/a";

                switch (tokens.length){
                    case 3:
                        if (Character.isDigit(tokens[2].charAt(0))){
                            weight = tokens[2];
                        }
                        else {
                           color = tokens[2];
                        }
                        break;

                    case 4:
                        if (Character.isDigit(tokens[2].charAt(0))){
                            weight = tokens[2];
                            color = tokens[3];
                        }
                        else {
                            color = tokens[2];
                            weight = tokens[3];
                        }
                        break;
                }
                 for (int i = 0; i < engineList.size(); i++) {
                     if (engineModel.equals(engineList.get(i).engineModel)){
                         exactEngine.add(engineList.get(i));
                     }
                 }
                 Car car = new Car(carModel,exactEngine,weight,color);
                carList.add(car);

      System.out.printf("%s:%n%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s%n",
            car.getCarModel(),engineModel,exactEngine.get(0).getPower(),
            exactEngine.get(0).getDisplacement(),
              exactEngine.get(0).getEfficiency(),
                      car.getWeight(),car.getColor());

             }

    }

}
