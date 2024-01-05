public class GameMaster {

    public String describe(Character character) {
        return String.format("You're a level %d %s with %d hit points.",
                character.getLevel(), character.getCharacterClass(), character.getHitPoints());
    }

    public String describe(Destination destination) {
        return String.format("You've arrived at %s, which has %d inhabitants.",
                destination.getName(), destination.getInhabitants());
    }

    public String describe(TravelMethod travelMethod) {
        return String.format("You're traveling to your destination %s.",
                travelMethod.equals(TravelMethod.HORSEBACK) ? "on horseback" : "by walking");
    }

    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        return String.format("%s %s %s", describe(character), describe(travelMethod), describe(destination));
    }

    public String describe(Character character, Destination destination) {
        return describe(character, destination, TravelMethod.WALKING);
    }
}
