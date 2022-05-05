import java.util.List;

public class Knapsack {

    public Knapsack() {

    }

    public int maximumValue(int knapsackLimit, List<Item> list) {
        return mValue(knapsackLimit, list, list.size());
    }

    private int mValue(int limit, List<Item> items, int n) {

        if (n == 0 || limit == 0) {
            return 0;
        }

        if (items.get(n - 1).getWeight() > limit) {
            return mValue(limit, items, n - 1);
        } else {
            return Math.max(items.get(n - 1).getValue() + mValue(limit - items.get(n - 1).getWeight(), items, n - 1),
                                mValue(limit, items, n - 1));
        }
    }
}

class Item{

    private final int weight;
    private final int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getValue() {
        return this.value;
    }

    
}