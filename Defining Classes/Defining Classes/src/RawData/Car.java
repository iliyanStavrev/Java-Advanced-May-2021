package RawData;

import java.util.List;

public class Car {
    String model;
    Engine engine;
    Cargo cargo;
    List<Tires>tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tires>tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public List<Tires> getTires() {
        return tires;
    }

    public Engine getEngine() {
        return engine;
    }
}
