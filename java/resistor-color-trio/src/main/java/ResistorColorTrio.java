import java.util.Map;

class ResistorColorTrio {

    private static final long GIGA = 1_000_000_000;
    private static final long MEGA = 1_000_000;
    private static final long KILO = 1_000;

    private Map<String, Integer> encoding;

    public ResistorColorTrio() {
        this.encoding = Map.of("black", 0, "brown", 1, "red", 2, "orange", 3, "yellow", 4, "green", 5, "blue", 6, "violet", 7, "grey", 8, "white", 9);
    }

    String label(String[] colors) {
        long resistance = this.encoding.get(colors[0]) * 10 + this.encoding.get(colors[1]);
        resistance *= Math.pow(10, this.encoding.get(colors[2]));

        return formatOutput(resistance);
    }

    private String formatOutput(long value) {

        if (value >= GIGA) {
            return "" + (value / GIGA) + " gigaohms";
        }

        if (value >= MEGA) {
            return "" + (value / MEGA) + " megaohms";
        }

        if (value >= KILO) {
            return "" + (value / KILO) + " kiloohms";
        }

        return "" + value + " ohms";
    }
}
