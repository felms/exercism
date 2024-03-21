class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    private int distanceTravelled;
    private int numberOfVictories;

    public ProductionRemoteControlCar() {
        this.distanceTravelled = 0;
        this.numberOfVictories = 0;
    }

    @Override
    public void drive() {
        this.distanceTravelled += 10;
    }

    @Override
    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public int getNumberOfVictories() {
        return this.numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }
   
    @Override
    public int compareTo(ProductionRemoteControlCar other) {
        return other.getNumberOfVictories() - this.numberOfVictories;
    }
}
