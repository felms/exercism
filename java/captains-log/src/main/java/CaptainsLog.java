import java.util.Random;

class CaptainsLog {

    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    private Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    char randomPlanetClass() {
        return PLANET_CLASSES[this.random.nextInt(PLANET_CLASSES.length)];
    }

    String randomShipRegistryNumber() {
        return String.format("NCC-%s", (this.random.nextInt(9000) + 1000));
    }

    double randomStardate() {
        return 41000.0 + 1000.0 * this.random.nextDouble();
    }
}
