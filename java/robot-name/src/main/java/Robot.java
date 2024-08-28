import java.util.HashSet;
import java.util.Set;

class Robot {

    private static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Set<String> usedNames = new HashSet<>();

    private String name;

    public Robot() {
        this.name = this.createName();
    }

    String getName() {
        return this.name;
    }

    void reset() {
        this.name = this.createName();
    }

    private String createName() {

        String createdName = "";

        do {
            char letter0 = ALPHABET.charAt((int) (Math.random() * 26));
            char letter1 = ALPHABET.charAt((int) (Math.random() * 26));
            int number = 100 + (int) (Math.random() * 900);

            createdName = String.format("%s%s%d", letter0, letter1, number);
        } while(usedNames.contains(createdName));

        usedNames.add(createdName);
        return createdName;
    }

}
