package CarSalesman;

public class Engine {
    String engineModel;
    String power;
    String displacement;
    String efficiency;

    public  Engine(String engineModel,String power){
        this(engineModel,power,"n/a","n/a");
    }

    public Engine(String engineModel, String power,String displacement, String efficiency) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public String getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

}

