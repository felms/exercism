public class PigLatinTranslator {

    public String translate(String input) {

        StringBuilder sb = new StringBuilder();

        String[] words = input.split("\\s+");

        for (String word : words) {
            if (word.matches("^(xr|yt).*|^[aeiou].*")) {
                sb.append(rule1(word));
            } else if (word.matches("[^aeiou]*qu.*")) {
                sb.append(rule3(word));
            } else if ((word.length() == 2 && word.charAt(1) == 'y') 
                || word.matches("^[^aeiou]+y.*")) {
                sb.append(rule4(word));
            } else if (word.matches("^([^aeiou]+).*")) {
                sb.append(rule2(word));
            }

            sb.append(" ");
        }

        return sb.toString().trim();
    }

    private String rule1(String input) {
        return input + "ay";
    }

    private String rule2(String input) {
        String consonants = input.split("[aeiou]")[0];
        String endOfWord = input.substring(consonants.length());

        return endOfWord + consonants + "ay";
    }

    private String rule3(String input) {
        String[] tokens = input.split(".*qu");
        String endOfWord = tokens[tokens.length - 1];
        String consonants = input.replace(endOfWord, "");

        return endOfWord + consonants + "ay";
    }

    private String rule4(String input) {
        String[] tokens = input.split("y");
        String consonants = tokens[0];
        String endOfWord = input.replace(consonants, "");

        return endOfWord + consonants + "ay";
        
    }
}