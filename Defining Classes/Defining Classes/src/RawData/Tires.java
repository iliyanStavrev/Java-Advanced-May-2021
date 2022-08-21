package RawData;

public class Tires {

    double pressure1;
    double pressure2;
    double pressure3;
    double pressure4;

    int ageTire1;
    int ageTire2;
    int ageTire3;
    int ageTire4;

    public Tires(double pressure1, double pressure2,
                 double pressure3, double pressure4,
                 int ageTire1, int ageTire2, int ageTire3, int ageTire4) {
        this.pressure1 = pressure1;
        this.pressure2 = pressure2;
        this.pressure3 = pressure3;
        this.pressure4 = pressure4;
        this.ageTire1 = ageTire1;
        this.ageTire2 = ageTire2;
        this.ageTire3 = ageTire3;
        this.ageTire4 = ageTire4;
    }

    public double getPressure1() {
        return pressure1;
    }

    public double getPressure2() {
        return pressure2;
    }

    public double getPressure3() {
        return pressure3;
    }

    public double getPressure4() {
        return pressure4;
    }
}
