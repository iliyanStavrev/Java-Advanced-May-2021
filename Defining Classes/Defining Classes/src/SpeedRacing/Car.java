package SpeedRacing;

public class Car {
    String model;
    double fuelAmount;
    double fuelCostForKm;
    int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostForKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForKm = fuelCostForKm;
    }

    public String getModel() {
        return model;
    }
    public double getFuelAmount() {
        return fuelAmount;
    }
    public double getFuelCostForKm() {
        return fuelCostForKm;
    }
    public int getDistanceTraveled() {
        return distanceTraveled;
    }
     public void Drive(int distance){
        if (distance * fuelCostForKm <= fuelAmount){
            distanceTraveled += distance;
            fuelAmount -= distance * fuelCostForKm;
        }
        else {
            System.out.println("Insufficient fuel for the drive");
        }

     }
}
