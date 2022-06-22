import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

public class RailFenceCipher{
	
	private List<List<String>> railFence;
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

    public String getDecryptedData(String inputString) {

	    String input = inputString;

	    // Criei uma matrix com numeroDeRails (linhas)
	    // por tamanhoDaString (colunas)
	    this.railFence = new ArrayList<>();
	    for (int i = 0; i < this.numberOfLists; i++) {

	        List<String> rail = new ArrayList<>();

	        for (int j = 0; j < inputString.length(); j++){
                rail.add("_");
	        }
	        railFence.add(rail);

	    }

        
	    int step = 1;
	    int pos = 0;
	    int row = 0;
	    int column = 0;
	    
		// Marquei na matriz as posições que receberão 
	    // as letras
	    while (pos < input.length()) {

            this.railFence.get(row).set(column, "*");            
	        column++;
	        pos++;

	        if (row == this.numberOfLists - 1) {
	            step = -1;
	        } else if (row == 0) {
                step = 1;
	        }

            row += step;		
	    }

	    // Inseri as letras na matriz.
        for (int i = 0; i < this.numberOfLists; i++) {
	     
			List<String> rail = this.railFence.get(i);
            for (int j = 0; j < rail.size(); j++) {
                if (rail.get(j).equals("*")) {
                    String letter = input.substring(0, 1);
                    input = input.substring(1);
                    rail.set(j, letter);
		        }
	        }
	    }	    


	    // Fiz a leitura dos dados
        step = 1;
	    pos = 0;
	    row = 0;
	    column = 0;
	    StringBuilder sb = new StringBuilder();

		while (pos < inputString.length()) {

            String s = this.railFence.get(row).get(column);
            sb.append(s);
	        column++;
	        pos++;

	        if (row == this.numberOfLists - 1) {
	            step = -1;
	        } else if (row == 0) {
                step = 1;
	        }

            row += step;		
	    }

	    return sb.toString();
    }
}
