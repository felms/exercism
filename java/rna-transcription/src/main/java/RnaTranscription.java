import java.util.stream.Collectors;

class RnaTranscription {

    String transcribe(String dnaStrand) {
        return dnaStrand.chars()
            .mapToObj(c -> 
                    switch ((char)c) {
                        case 'G' -> "C";
                        case 'C' -> "G";
                        case 'T' -> "A";
                        case 'A' -> "U";
                        default -> "0";
                    }
            ) 
            .collect(Collectors.joining());
    }

}
