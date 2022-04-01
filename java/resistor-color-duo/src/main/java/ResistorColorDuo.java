import java.util.List;

class ResistorColorDuo {
    int value(String[] colors) {
        List<String> colorCodes = List.of("black", "brown" ,"red", "orange",
                                            "yellow", "green", "blue", "violet",
                                            "grey", "white");

        int a = colorCodes.indexOf(colors[0].toLowerCase());
        int b = colorCodes.indexOf(colors[1].toLowerCase());

        return Integer.parseInt(String.format("%s%s", a, b));
    }
}
