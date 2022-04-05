public class Bob{

    public String hey(String question) {
        question = question.trim();

        if ("".equals(question)) {
            return "Fine. Be that way!";
        }

        if (isQuestion(question)) {

            if (isAllSymbols(question)) {
                return "Sure.";
            }

            if (isUpperCase(question)) {
                return "Calm down, I know what I'm doing!";
            }
            
            return "Sure.";
        }

        if (isAllSymbols(question)) {
            return "Whatever.";
        }

        if (isUpperCase(question)) {
            return "Whoa, chill out!";
        }

        return "Whatever.";
    }
    
    private boolean isQuestion(String string) {
        return string.charAt(string.length() - 1) == '?';
    }
    
    private boolean isUpperCase(String string) {

        for(char c : string.toCharArray()) {
            if(Character.isLetter(c) && Character.isLowerCase(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean isAllSymbols(String string) {

        for (char c : string.toCharArray()) {
            if (Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }
}