class SpaceAge {

    private static final double EARTH_YEAR = 31557600;

    private static final double MERCURY_OP = 0.2408467;
    private static final double VENUS_OP = 0.61519726;
    private static final double MARS_OP = 1.8808158;
    private static final double JUPITER_OP = 11.862615;
    private static final double SATURN_OP = 29.447498;
    private static final double URANUS_OP = 84.016846;
    private static final double NEPTUNE_OP = 164.79132;

    private final double age;

    SpaceAge(double seconds) {
        this.age = seconds;
    }

    double getSeconds() {
        return this.age;
    }

    double onEarth() {
        return this.age / EARTH_YEAR;
    }

    double onMercury() {
        return this.onEarth() / MERCURY_OP;
    }

    double onVenus() {
        return this.onEarth() / VENUS_OP;

    }

    double onMars() {
        return this.onEarth() / MARS_OP;

    }

    double onJupiter() {
        return this.onEarth() / JUPITER_OP;

    }

    double onSaturn() {
        return this.onEarth() / SATURN_OP;

    }

    double onUranus() {
        return this.onEarth() / URANUS_OP;

    }

    double onNeptune() {
        return this.onEarth() / NEPTUNE_OP;

    }

}
