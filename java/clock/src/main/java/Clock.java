public class Clock {

    private int minutes;

    public Clock(int hours, int minutes) {
        int h = hours;
        int m = minutes;

        if (minutes >= 60) {
            m = minutes % 60;
            h += minutes / 60;
        }

        h = h >= 24 ? h % 24 : h;

        this.minutes = m;
        this.minutes += h * 60;
    }

    public void add(int minutes) {
        // TODO
    }

    @Override
    public String toString() {
        int h = this.minutes / 60;
        int m = this.minutes % 60;
        return String.format("%02d:%02d", h, m);
    }
}