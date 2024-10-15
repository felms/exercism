class Clock {

    private final static int ONE_HOUR_MINUTES = 60;
    private final static int ONE_DAY_IN_MINUTES = 1440;

    private int minutes;

    Clock(int hours, int minutes) {
        this.minutes = 0;
        add(hours * ONE_HOUR_MINUTES + minutes);
    }

    void add(int minutes) {
        int m = (this.minutes + minutes) % ONE_DAY_IN_MINUTES;
        this.minutes = m >= 0 ? m : m + ONE_DAY_IN_MINUTES;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", this.minutes / ONE_HOUR_MINUTES, this.minutes % ONE_HOUR_MINUTES);
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        return this.toString().equals(obj.toString());
    }
}