package CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        List<Car>carList = new ArrayList<>();

        while (number -- > 0){
          String[]tokens = scanner.nextLine().split("\\s+");
          String brand = tokens[0];
          String model = tokens[1];
          int horsePower = Integer.parseInt(tokens[2]);

          Car car = new Car(brand,model,horsePower);

          carList.add(car);
        }
        System.out.print(carList.toString().replaceAll("[\\[\\],]",""));
    }
}
