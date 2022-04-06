import java.util.Arrays;
import java.util.Random;

class DnDCharacter {
    
    private Random random;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom ;
    private int charisma;
    private int hitPoints;

    public DnDCharacter() {
        this.random = new Random();
        this.strength = ability();
        this.dexterity = ability();
        this.constitution = ability();
        this.intelligence = ability();
        this.wisdom = ability();
        this.charisma = ability();
        this.hitPoints = 10 + modifier(this.constitution);
    }

    int ability() {
        int d1 = this.random.nextInt(6) + 1;
        int d2 = this.random.nextInt(6) + 1;
        int d3 = this.random.nextInt(6) + 1;
        int d4 = this.random.nextInt(6) + 1;

        int[] arr = {d1, d2, d3, d4};
        Arrays.sort(arr);
        int sum = 0;

        for (int i = 3; i > 0; i--) {
            sum += arr[i];
        }

        return sum;
    }

    int modifier(int input) {
        double m = input - 10;
        return (int)Math.floor(m / 2.0);
    }

    int getStrength() {
        return this.strength;
    }

    int getDexterity() {
        return this.dexterity;
    }

    int getConstitution() {
        return this.constitution;
    }

    int getIntelligence() {
        return this.intelligence;
    }

    int getWisdom() {
        return this.wisdom;
    }

    int getCharisma() {
        return this.charisma;
    }

    int getHitpoints() {
        return this.hitPoints;
    }
}