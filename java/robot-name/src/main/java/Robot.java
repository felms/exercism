import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Robot{

    public static final List<String> usedNames = new ArrayList<>();

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String name;

    public Robot() {
        this.name = createName();
    }

    public String getName() {
        return this.name;
    }

    public void reset() {
        this.name = createName();
    }

    private String createName() {
        String name;

        do{
            name = randomName();
        }while(usedNames.contains(name));

        usedNames.add(name);
        return name;
    }

    private String randomName() {
        StringBuilder name = new StringBuilder();
        Random r = new Random();
        int pos0 = r.nextInt(ALPHABET.length());
        int pos1 = r.nextInt(ALPHABET.length());
        
        name.append(ALPHABET.charAt(pos0));
        name.append(ALPHABET.charAt(pos1));
        name.append(String.valueOf(r.nextInt(10)));
        name.append(String.valueOf(r.nextInt(10)));
        name.append(String.valueOf(r.nextInt(10)));

        return name.toString();
    }
}