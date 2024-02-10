public class Lasagna {

    public int expectedMinutesInOven() {
        return 40;
    }

    public int remainingMinutesInOven(int timeInOven) {
        return this.expectedMinutesInOven() - timeInOven;
    }

    public int preparationTimeInMinutes(int numberOfLayers) {
        return numberOfLayers * 2;
    }

    public int totalTimeInMinutes(int numberOfLayers, int timeInOven) {
        return preparationTimeInMinutes(numberOfLayers) + timeInOven;
    }
}
