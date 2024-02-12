import java.util.Map;

class SqueakyClean {
    static String clean(String identifier) {

        if (identifier.length() < 2) {
            return identifier;
        }

        String s = identifier.replaceAll("\\s", "_");

        if (s.matches(".*-.*")) {
            s = kebabToCamelCase(s);
        }

        return leetSpeakToNormalText(s).replaceAll("\\W", "");
    }

    private static String kebabToCamelCase(String identifier) {

        String[] word = identifier.split("-");
        StringBuilder res = new StringBuilder(word[0].toLowerCase());

        for (int i = 1; i < word.length; i++) {
            StringBuilder newWord = new StringBuilder(word[i]);
            String firstLetter = newWord.substring(0, 1).toUpperCase();
            newWord.replace(0, 1, firstLetter);
            res.append(newWord);
        }

        return res.toString();
    }

    private static String leetSpeakToNormalText(String identifier) {
        Map<Character, Character> translation = Map.of(
                '0', 'o',
                '1', 'l',
                '3', 'e',
                '4', 'a',
                '7', 't'
        );

        StringBuilder res = new StringBuilder();

        for (char c : identifier.toCharArray()) {
            res.append(translation.getOrDefault(c, c));
        }

        return res.toString();
    }
}
