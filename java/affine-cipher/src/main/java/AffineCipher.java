import java.util.List;
import java.util.stream.Collectors;

public class AffineCipher {

    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final int M = 26;

    public String encode(String inputText, int a, int b) {

        // Testa se os números são coprimos
        int gcdAB = gcd(a, M);
        if (gcdAB != 1) {
            throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");
        }

        List<String> letters = List.of(inputText.toLowerCase()
                .replaceAll("[\\W]", "")
                .split(""));

        String encodedText = letters.stream()
                .map(letter -> this.encodeChar(letter, a, b))
                .collect(Collectors.joining());

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (char c : encodedText.toCharArray()) {
            sb.append(c);
            if (count % 5 == 0) {
                sb.append(" ");
            }
            count++;
        }

        return sb.toString().trim();
    }

    public String decode(String encodedText, int a, int b) {

        // Testa se os números são coprimos
        int gcdAB = gcd(a, M);
        if (gcdAB != 1) {
            throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");
        }

        List<String> letters = List.of(encodedText.toLowerCase()
                .replaceAll("[\\W]", "")
                .split(""));

        return letters.stream()
                .map(letter -> this.decodeChar(letter, a, b))
                .collect(Collectors.joining());
    }

    private String encodeChar(String c, int a, int b) {

        int x = ALPHABET.indexOf(c);

        // Caso não seja uma letra
        if (x < 0) {
            return c;
        }

        // Função de criptografia
        int eX = (a * x + b) % M;

        return String.valueOf(ALPHABET.charAt(eX));
    }

    private String decodeChar(String c, int a, int b) {

        int y = ALPHABET.indexOf(c);

        // Caso não seja uma letra
        if (y < 0) {
            return c;
        }

        // Encontra o multiplicativo modular inverso
        int a1 = mmi(a);

        // Aplica a função de descriptografia
        int dY = (a1 * (y - b)) % M;

        // Ajusta o range para o caso de valores fora do limite (0 - 25)
        dY = dY < 0 ? dY + M : dY;

        return String.valueOf(ALPHABET.charAt(dY));

    }

    // Acha o máximo divisor comum
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    // Acha o multiplicativo modular inverso
    private int mmi(int a) {

        int b = 0;

        for (int i = 0; i < M; i++) {
            int r = (a * i) % M;
            if (r == 1) {
                b = i;
            }
        }

        return b;
    }
}