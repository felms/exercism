import java.util.Map;

class ResistorColorDuo {
    int value(String[] colors) {
        Map<String, Integer> bandColors = Map.of(
                "black", 0, "brown", 1, "red", 2, "orange", 3, "yellow", 4, 
                "green", 5, "blue", 6, "violet", 7, "grey", 8, "white", 9);

        return (bandColors.get(colors[0]) * 10) + bandColors.get(colors[1]);
    }
}
