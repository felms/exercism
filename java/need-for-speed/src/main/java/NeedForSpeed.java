class NeedForSpeed {

    private final int speed;
    private final int batteryDrain;
    private int distanceDriven;
    private int battery;
    
    public NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.distanceDriven = 0;
        this.battery = 100;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getBatteryDrain() {
        return this.batteryDrain;
    }

    public boolean batteryDrained() {
        return this.battery == 0;
    }

    public int distanceDriven() {
        return this.distanceDriven;
    }

    public void drive() {
        if (this.battery > 0) {
            this.distanceDriven += this.speed;
            this.battery -= this.batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    
    private final int distance;

    public RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean tryFinishTrack(NeedForSpeed car) {
        int carMaxDistance = car.getSpeed() * (100 / car.getBatteryDrain());
        return carMaxDistance >= this.distance;
    }
}
