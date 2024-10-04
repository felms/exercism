public class Cipher {

    private static final int ALPHABET_LENGTH = 26;
    private static final char FIRST_LETTER = 'a';
    private static final char LAST_LETTER = 'z';

    private final String key;

    public Cipher() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 100; i++) {
            sb.append((char) (((int) Math.random() * ALPHABET_LENGTH) + FIRST_LETTER));
        }

        this.key = sb.toString();
    }

    public Cipher(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public String encode(String plainText) {

        int keyLength = this.key.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            int shift = this.key.charAt(i % keyLength) - FIRST_LETTER;
            int pos = (plainText.charAt(i) + shift);
            pos = pos > LAST_LETTER ? (pos - ALPHABET_LENGTH) : pos;
            sb.append((char) pos);
        }

        return sb.toString();
    }

    public String decode(String cipherText) {

        int keyLength = this.key.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            int shift = this.key.charAt(i % keyLength) - FIRST_LETTER;
            int pos = ((cipherText.charAt(i) - shift));
            pos = pos < FIRST_LETTER ? (pos + ALPHABET_LENGTH) : pos;
            sb.append((char) pos);
        }

        return sb.toString();
    }
}
