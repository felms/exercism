public class ElonsToyCar {

    private int distanceDriven;
    private int batteryCharge;

    public ElonsToyCar() {
        this.distanceDriven = 0;
        this.batteryCharge = 100;
    }
    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + this.distanceDriven + " meters";
    }

    public String batteryDisplay() {
        return this.batteryCharge > 0
                ? "Battery at " + this.batteryCharge + "%"
                : "Battery empty";
    }

    public void drive() {
        if (this.batteryCharge > 0) {
            this.distanceDriven += 20;
            this.batteryCharge--;
        }
    }
}
