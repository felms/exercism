class SpaceAge {

    private double ageOnEarth;

    SpaceAge(double seconds) {
        this.ageOnEarth = seconds / 31_557_600;
    }

    double onEarth() {
        return this.ageOnEarth;
    }

    double onMercury() {
        return this.ageOnEarth / 0.2408467;
    }

    double onVenus() {
        return this.ageOnEarth / 0.61519726;
    }

    double onMars() {
        return this.ageOnEarth / 1.8808158;
    }

    double onJupiter() {
        return this.ageOnEarth / 11.862615;
    }

    double onSaturn() {
        return this.ageOnEarth / 29.447498;
    }

    double onUranus() {
        return this.ageOnEarth / 84.016846;
    }

    double onNeptune() {
        return this.ageOnEarth / 164.79132;
    }

}
