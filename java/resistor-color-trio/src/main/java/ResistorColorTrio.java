import java.util.Map;

class ResistorColorTrio {
    String label(String[] colors) {
        Map<String, Integer> bandColors = Map.of(
                "black", 0, "brown", 1, "red", 2, "orange", 3, "yellow", 4, 
                "green", 5, "blue", 6, "violet", 7, "grey", 8, "white", 9);

        long resistance = ((bandColors.get(colors[0]) * 10) + bandColors.get(colors[1]))
                            * (long)Math.pow(10, bandColors.get(colors[2]));

        return resistance >= 1_000_000_000 ? (resistance / 1_000_000_000) + " gigaohms"
                        : resistance >= 1_000_000 ? (resistance / 1_000_000) + " megaohms"
                        : resistance >= 1_000 ? (resistance / 1_000) + " kiloohms" 
                        : resistance + " ohms";

    }
}
