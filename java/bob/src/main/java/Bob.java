class Bob {

    String hey(String input) {

        String inputString = input.trim();

        if (inputString.isEmpty()) {
            return "Fine. Be that way!";
        }

        if (isYelling(inputString) && isQuestion(inputString)) {
            return "Calm down, I know what I'm doing!";
        }

        if (isQuestion(inputString)) {
            return "Sure.";
        }

        if (isYelling(inputString)) {
            return "Whoa, chill out!";
        }

        return "Whatever.";
    }

    private boolean isQuestion(String input) {
        return input.matches(".*\\?$");
    }

    private boolean isYelling(String input) {
        String str = input.replaceAll("[^a-zA-Z]", "");
        return !str.isEmpty()
                && str.chars().mapToObj(c -> (char) c).allMatch(Character::isUpperCase);
    }

}