import java.util.List;
import java.util.Random;

class DnDCharacter {

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int hitpoints;

    public DnDCharacter() {
        this.strength = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.constitution = ability(rollDice());
        this.intelligence = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.charisma = ability(rollDice());

        this.hitpoints = 10 + modifier(this.constitution);
    }

    int ability(List<Integer> scores) {
        return scores.stream().sorted((a, b) -> b - a)
                        .mapToInt(Integer::intValue).limit(3).sum();
    }

    List<Integer> rollDice() {
        return new Random().ints(4, 1, 7).boxed().toList();
    }

    int modifier(int input) {
        return (int)Math.floor((input - 10.0) / 2.0);
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
        return this.hitpoints;
    }
}
