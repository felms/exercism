import java.util.Arrays;
import java.util.List;

public class PangramChecker {

    private final List<String> alphabet;

    public PangramChecker(){
        this.alphabet = Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")); 
    }

    
    public boolean isPangram(String input) {
        return Arrays.asList(input.toLowerCase().split(""))
			.containsAll(this.alphabet);
    }

}
