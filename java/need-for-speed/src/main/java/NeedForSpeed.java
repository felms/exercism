class NeedForSpeed {

    private int speed;
    private int batteryDrain;
    private int batteryPercentage;
    private int distanceDriven;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.batteryPercentage = 100;
        this.distanceDriven = 0;
    }

    public boolean batteryDrained() {
        return this.batteryPercentage == 0;
    }

    public int distanceDriven() {
        return this.distanceDriven;
    }

    public void drive() {

        if (this.batteryPercentage >= this.batteryDrain){
            this.distanceDriven += this.speed;
            this.batteryPercentage -= this.batteryDrain;

        }

    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {

    private int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean tryFinishTrack(NeedForSpeed car) {

        while(!car.batteryDrained()) {
            car.drive();
        }

        return car.distanceDriven() >= this.distance;
    }
}
