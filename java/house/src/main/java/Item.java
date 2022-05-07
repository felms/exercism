public class Item {
    
    private final String name;
    private final String action;

    public Item(String name, String action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return this.name;
    }

    public String getAction() {
        return this.action;
    }
}
