import java.util.Arrays;

class ResistorColor {

    private String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

    int colorCode(String color) {
        return Arrays.asList(this.colors).indexOf(color);
    }

    String[] colors() {
        return this.colors.clone();
    }
}
