import java.util.Random;

class CaptainsLog {

    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    private Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    char randomPlanetClass() {
        int pos = this.random.nextInt(PLANET_CLASSES.length);
        return PLANET_CLASSES[pos];
    }

    String randomShipRegistryNumber() {
        int shipNumber = this.random.nextInt(9000) + 1000;
        return "NCC-" + shipNumber;
    }

    double randomStardate() {
        return 41_000 + (1_000 * this.random.nextDouble());
    }
}
