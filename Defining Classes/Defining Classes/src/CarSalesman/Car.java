package CarSalesman;

import java.util.List;

public class Car {

    private String carModel;
   private List<Engine> engine;
   private String weight;
    private String color;


    public Car(String carModel,List<Engine>engine){
        this(carModel,engine,"n/a","n/a");
    }

    public Car(String carModel,List<Engine>engine,String weight,String color) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getCarModel() {
        return carModel;
    }

    public List<Engine>getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

}
