public class Clock {

    private int minutes;

    public Clock(int hours, int minutes) {

        int h = hours >= 0 ? hours % 24 : 24 + hours % 24;

        int m = 0;
        if (minutes >= 60) {
            h += minutes / 60;
            h %= 24;
            m = minutes % 60;
        } else if (minutes >= 0) {
            m = minutes;
        } else {
            m = -Math.abs(minutes) % 60;
            h += -(Math.abs(minutes) % 1440) / 60;
            h = h < 0 ? 24 + h : h;
        }

        this.minutes = h * 60;
        this.minutes += m;
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