import java.util.Random;

public class Cipher {

    private static final char FIRST_LETTER = 'a';
    private static final int ALPHABET_LENGTH = 26;

    private final String key;

    public Cipher() {
        this(generateRandomKey());
    }

    public Cipher(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public String encode(String textToEncode) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < textToEncode.length(); i++) {
            int shift = this.key.charAt(i) - textToEncode.charAt(i); 
            shift = shift < 0 ? shift + ALPHABET_LENGTH : shift;
            shift %= ALPHABET_LENGTH;
            sb.append((char) (FIRST_LETTER + shift));
        }

        return sb.toString();
    }

    public String decode(String textToDecode) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < textToDecode.length(); i++) {
            int shift = this.key.charAt(i) - textToDecode.charAt(i); 
            shift = shift < 0 ? shift + ALPHABET_LENGTH : shift;
            shift %= ALPHABET_LENGTH;
            sb.append((char) (FIRST_LETTER + shift));
        }

        return sb.toString();
    }

    private static String generateRandomKey() {
        StringBuilder sb = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int pos = random.nextInt(ALPHABET_LENGTH);
            sb.append((char) (FIRST_LETTER + pos));
        }
        System.out.println(sb);
        return sb.toString();
    }
}