import java.util.List;
import java.util.stream.Collectors;

public class RunLengthEncoding {
	
	public String encode(String inputString){
		
		if (inputString.equals("")) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();

		String[] letters = (inputString + "*").split(""); // TODO Tirar essa gambiarra
		String previousLetter = letters[0];
		int letterCount = 1;
		for (int i = 1; i < letters.length; i++) {
			if (letters[i].equals(previousLetter)) {
				letterCount++;
			} else if (letterCount > 1){
				sb.append("" + letterCount + previousLetter);
				letterCount = 1;
			} else if (letterCount == 1) {
				sb.append(previousLetter);
				letterCount = 1;
			}
			previousLetter = letters[i];
		}

		return sb.toString();
	}
	
	public String decode(String inputString){
		
		StringBuilder sb = new StringBuilder();
		List<Character> letters = inputString.chars()
									.mapToObj(c -> Character.valueOf((char) c))
									.collect(Collectors.toList());

		while (!letters.isEmpty()) {
			char letter = letters.remove(0);
			
			if (Character.isDigit(letter)) {
				StringBuilder number = new StringBuilder();
				number.append(letter);
				while (Character.isDigit(letters.get(0))) {
					number.append(letters.remove(0));
				}
				letter = letters.remove(0);
				int n = Integer.parseInt(number.toString());
				for (int i = 0; i < n; i++) {
					sb.append(letter);
				}
			} else {
				sb.append(letter);
			}
		}				

		return sb.toString();
	}

}
