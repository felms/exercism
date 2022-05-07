import java.util.ArrayList;
import java.util.List;

public class House{

    private List<Item> items;

    public House() {
        items = new ArrayList<>();
        items.add(new Item("", ""));
        items.add(new Item("", ""));
        items.add(new Item("the malt", "that lay in the house that Jack built."));
        items.add(new Item("the rat", "ate"));
        items.add(new Item("the cat", "killed"));
        items.add(new Item("the dog", "worried"));
        items.add(new Item("the cow with the crumpled horn", "tossed"));
        items.add(new Item("the maiden all forlorn", "milked"));
        items.add(new Item("the man all tattered and torn", "kissed"));
        items.add(new Item("the priest all shaven and shorn", "married"));
        items.add(new Item("the rooster that crowed in the morn", "woke"));
        items.add(new Item("the farmer sowing his corn", "kept"));
        items.add(new Item("the horse and the hound and the horn", "belonged to"));
    }

    public String verse(int number) {

        if (number == 1) {
            return "This is the house that Jack built.";
        }

        return "This is " + recVerse(number);
        
    }

    public String verses(int startVerse, int endVerse) {
        StringBuilder sb = new StringBuilder();

        for (int i = startVerse; i <= endVerse; i++) {
            sb.append(verse(i)).append("\n");
        }

        return sb.toString().trim();
    }

    public String sing() {
        StringBuilder sb = new StringBuilder();
        sb.append(verse(1)).append("\n");

        sb.append(verses(2, this.items.size() - 1));

        return sb.toString();
    }

    public String recVerse(int number) {
        if(number == 2){
            return items.get(number).getName() + " " + items.get(number).getAction();
        }

        return items.get(number).getName() + " that " + items.get(number).getAction() + " " + recVerse(number - 1);
    }
}