import java.util.Arrays;

class Scrabble {

    private String word;

    Scrabble(String word) {
        this.word = word.toUpperCase();
    }

    int getScore() {
        return Arrays.stream(this.word.split("")).mapToInt(this::scoreLetter).sum();
    }

    int scoreLetter(String letter) {
        return switch (letter) {
            case "A", "E", "I", "O", "U", "L", "N", "R", "S", "T" -> 1;
            case "D", "G" -> 2;
            case "B", "C", "M", "P" -> 3;
            case "F", "H", "V", "W", "Y" -> 4;
            case "K" ->	5;
            case "J", "X" -> 8;
            case "Q", "Z" -> 10;
            default -> 0;
        };
    }
}
