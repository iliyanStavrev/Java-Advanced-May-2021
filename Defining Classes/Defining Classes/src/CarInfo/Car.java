package CarInfo;

public class Car {
         String brand;
         String model;
         int horsePower;

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }
    @Override
    public String toString(){
        return String.format("The car is: %s %s - %d HP.%n",this.brand,this.model,this.horsePower);
    }
}
