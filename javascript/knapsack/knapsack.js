export const knapsack = (maximumWeight, items) => {
    let bestKnapsack = permutations(maximumWeight, items, [], []);

    return knapsackSum(bestKnapsack);

};

const permutations = (maximumWeight, items, currentKnapsack, bestKnapsack) => {

    if (maximumWeight < 0) {
        return bestKnapsack;
    }

    if (items.length === 0 || items[0].weight > maximumWeight) {

        return (knapsackSum(currentKnapsack) > knapsackSum(bestKnapsack)) 
            ? currentKnapsack : bestKnapsack;
    }

    for (let i = 0; i < items.length; i++) {
        let item = items[i];
        bestKnapsack = permutations(maximumWeight - item.weight, items.slice(i + 1), [...currentKnapsack, item], bestKnapsack);
    }

    return bestKnapsack;
};

const knapsackSum = (knapsack) => knapsack.reduce((sum, item) => sum + item.value, 0);
