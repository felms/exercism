export const knapsack = (maximumWeight, items) => {
    let sortedItems = items.toSorted((a, b) => a.weight - b.weight);
    let bestKnapsack = permutations(maximumWeight, sortedItems, [], []);

    return knapsackSum(bestKnapsack);

};

const permutations = (maximumWeight, items, currentKnapsack, bestKnapsack) => {

    if (maximumWeight < 0) {
        return bestKnapsack;
    }

    if (items.length === 0 || items[0].weight > maximumWeight) {
        if (knapsackSum(currentKnapsack) > knapsackSum(bestKnapsack)) {
            return [...currentKnapsack];
        }

        return bestKnapsack;
    }

    for (let i = 0; i < items.length; i++) {
        let item = items[i];
        items.splice(i, 1);
        bestKnapsack = permutations(maximumWeight - item.weight, items, [...currentKnapsack, item], bestKnapsack);
        items.splice(i, 0, item);
    }

    return bestKnapsack;
};

const knapsackSum = (knapsack) => knapsack.reduce((sum, item) => sum + item.value, 0);
