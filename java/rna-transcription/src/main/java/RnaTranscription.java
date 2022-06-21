import java.util.Arrays;
import java.util.stream.Collectors;

class RnaTranscription {

    String transcribe(String dnaStrand) {
        return Arrays.asList(dnaStrand.split(""))
                        .stream()
                        .map(this::getComplement)
                        .collect(Collectors.joining());
    }

    private String getComplement(String nucleotide) {
        String result = "";

        switch (nucleotide) {
            case "G":
                result = "C";
                break;
            case "C":
                result = "G";
                break;
            case "T":
                result = "A";
                break;
            case "A":
                result = "U";
                break;
            default:
                result = "";
                break;

        };

        return result;
    }

}
