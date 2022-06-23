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
		return null;
	}

}
