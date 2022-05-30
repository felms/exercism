public class WordProblemSolver {

    public int solve(String string) {

        try{
            int result = 0;

            String operation = string.replace("What is ", "");
            String[] tokens = operation.split("\\s+(by)*\\s*");
    
            if (tokens.length == 1) {            
                String number = tokens[0].replaceAll("[^\\d]", "");
                result = Integer.parseInt(number);
            } else if (tokens.length == 3) {
                int firstNumber = Integer.parseInt(tokens[0]);
                String oper = tokens[1];
                int secondNumber = Integer.parseInt(tokens[2].replaceAll("[^-\\d]", ""));
    
                result = applyOperation(firstNumber, secondNumber, oper);
            } else if (tokens.length == 5) {
                int firstNumber = Integer.parseInt(tokens[0]);
                String firstOper = tokens[1];
                int secondNumber = Integer.parseInt(tokens[2]);
                String secondOper = tokens[3];
                int thirdNumber = Integer.parseInt(tokens[4].replaceAll("[^-\\d]", ""));
    
                result = applyOperation(firstNumber, secondNumber, firstOper);
                result = applyOperation(result, thirdNumber, secondOper);
            } else {
                throw new Exception();
            }
    
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }        
        
    }

    private int applyOperation(int firstNumber, int secondNumber, String operation){

        int result = 0;
        
        switch(operation) {
            case "plus":
                result = firstNumber + secondNumber;
                break;
            case "minus":
                result = firstNumber - secondNumber;
                break;
            case "multiplied":
                result = firstNumber * secondNumber;
                break;
            case "divided":
                result = firstNumber / secondNumber;
                break;
        }

        return result;
    }

}
