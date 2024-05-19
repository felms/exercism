import java.util.ArrayList;
import java.util.List;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        return splitString(rnaSequence).stream()
                .takeWhile(codon -> !codon.equals("UAA") && !codon.equals("UAG") && !codon.equals("UGA"))
                .map(codon -> switch (codon) {
                    case "AUG" -> "Methionine";
                    case "UUU", "UUC" -> "Phenylalanine";
                    case "UUA", "UUG" -> "Leucine";
                    case "UCU", "UCC", "UCA", "UCG" -> "Serine";
                    case "UAU", "UAC" -> "Tyrosine";
                    case "UGU", "UGC" -> "Cysteine";
                    case "UGG" -> "Tryptophan";
                    default -> throw new IllegalArgumentException("Invalid codon");
                })
                .toList();
    }

    List<String> splitString(String input) {
        List<String> res = new ArrayList<>();
        int size = input.length();

        for (int i = 0; i < size; i += 3) {
            res.add(input.substring(i, Math.min(size, i + 3)));
        }

        return res;
    }
}
