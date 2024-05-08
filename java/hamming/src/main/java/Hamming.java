import java.util.stream.IntStream;

public class Hamming {

    private int hammingDistance;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("strands must be of equal length");
        }

        this.hammingDistance = (int) IntStream.range(0, leftStrand.length())
            .filter(index -> leftStrand.charAt(index) != rightStrand.charAt(index)).count();
    }

    public int getHammingDistance() {
        return this.hammingDistance;
    }
}
