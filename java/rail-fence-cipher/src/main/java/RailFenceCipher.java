import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

public class RailFenceCipher{

    private final List<List<String>> railFence;
    private final int numberOfLists;

    public RailFenceCipher(int numberOfLists){
         
	this.numberOfLists = numberOfLists;
	this.railFence = new ArrayList<>();
	for (int i = 0; i < this.numberOfLists; i++) {
	    this.railFence.add(new ArrayList<>());
	}

    }

    public String getEncryptedData(String input) {
        
	String[] letters = input.split("");
	int step = 1;
	int pos = 0;

	for (int i = 0; i < letters.length; i++){
	    this.railFence.get(pos).add(letters[i]);
	    pos += step;
	    if(pos == this.numberOfLists - 1 || pos == 0) {
		    step *= -1;
	    }
	}


	StringBuilder sb = new StringBuilder();
	
	for (int i = 0; i < this.numberOfLists; i++){
	    sb.append(this.railFence.get(i).stream().collect(Collectors.joining()));
	}

	return sb.toString();
    }

    public String getDecryptedData(String input) {
	
	return "";
    }

}
