import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        List<String> proteins = new ArrayList<>();
        List<String> values = splitSequence(rnaSequence);
        
        for (String s : values) { 
            String protein = getProtein(s);

            if("STOP".equals(protein)) {
                break;
            }

            proteins.add(protein);
        }

        return proteins;
    }

    private List<String> splitSequence(String sequence) {
        List<String> values = new ArrayList<>();
        char[] seq = sequence.toCharArray();

        for (int i = 0; i < seq.length; i += 3) {
            values.add(new String(seq, i, 3));
        }

        return values;
    }

    private String getProtein(String s) {
        String p = "";

        switch(s) {
            case "AUG":
                p = "Methionine";
                break;
            case "UUU":
            case "UUC":
                p = "Phenylalanine";
                break;
            case "UUA":
            case "UUG":
                p = "Leucine";
                break;
            case "UCU":
            case "UCC":
            case "UCA":
            case "UCG":
                p = "Serine";
                break;
            case "UAU":
            case "UAC":
                p = "Tyrosine";
                break;
            case "UGU":
            case "UGC":
                p = "Cysteine";
                break;
            case "UGG":
                p = "Tryptophan";
                break;
            case "UAA":
            case "UAG":
            case "UGA":
                p = "STOP";

        }

        return p;
    }
}
