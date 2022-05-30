public class WordProblemSolver {

    public int solve(String string) {

        String initialPattern = "What is.*";

        if (!string.matches(initialPattern)) {
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }

        int result = 0;

        String operation = string.replace("What is ", "");
        String[] tokens = operation.split("\\s+");

        if (tokens.length == 1) {            
            String number = tokens[0].replaceAll("[^\\d]", "");
            result = Integer.parseInt(number);
        }

        return result;
    }

}
