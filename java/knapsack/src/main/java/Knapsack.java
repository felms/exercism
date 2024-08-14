import java.util.ArrayList;
import java.util.List;

class Knapsack {

    int maximumValue(int maximumWeight, List<Item> items) {
        return maxLoot(maximumWeight, items, 0);
    }

    int maxLoot(int maximumWeight, List<Item> items, int currentValue) {

        if (items.isEmpty() || maximumWeight == 0) {
            return currentValue;
        }

        List<Item> localItems = new ArrayList<>(items);
        Item item = localItems.remove(0);

        if (item.weight <= maximumWeight) {
            return Math.max(
                maxLoot(maximumWeight - item.weight, localItems, currentValue + item.value),
                maxLoot(maximumWeight, localItems, currentValue)
            );

        } else {
            return maxLoot(maximumWeight, localItems, currentValue);
        }
    }

}
