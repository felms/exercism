import java.util.Objects;

public class Clock {

    private final int DAY_IN_MINUTES = 1440;

    private int minutes;

    public Clock(int hours, int minutes) {

        int h = hours >= 0 ? hours % 24 : 24 + hours % 24;

        int m;
        if (minutes >= 60) {
            h += minutes / 60;
            h %= 24;
            m = minutes % 60;
        } else if (minutes >= 0) {
            m = minutes;
        } else {
            m = -Math.abs(minutes) % 60;
            h += -(Math.abs(minutes) % DAY_IN_MINUTES) / 60;
            h = h < 0 ? 24 + h : h;
        }

        this.minutes = h * 60;
        this.minutes += m;
    }

    public void add(int minutes) {
        minutes = minutes < 0 ? -(Math.abs(minutes) % DAY_IN_MINUTES) : minutes;
        this.minutes += minutes;
        this.minutes = this.minutes < 0 ? this.minutes + DAY_IN_MINUTES : this.minutes % DAY_IN_MINUTES;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        Clock clock = (Clock) o;

        return minutes == clock.minutes;
    }

    @Override
    public int hashCode() {
        return this.minutes * 37;
    }

    @Override
    public String toString() {
        int h = this.minutes / 60;
        int m = this.minutes % 60;
        return String.format("%02d:%02d", h, m);
    }
}