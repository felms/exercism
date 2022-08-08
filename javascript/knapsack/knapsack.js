export const knapsack = (maximumWeight, items) => {

  let sortedItems = [...items];
  sortedItems.sort((a, b) => a.value - b.value);

  let loot = mValue(maximumWeight, sortedItems, 0);
  return loot;
};

const mValue = (limit, items, loot) => {

  if (limit === 0 || items.length === 0) {
    return loot;
  }
 
  let localItems = [...items];
  let o = localItems.pop();
  if (o.weight <= limit) {
    return Math.max(
      mValue(limit - o.weight, localItems, loot + o.value),
      mValue(limit, localItems, loot)
    );
  } else {
    return mValue(limit, localItems, loot);
  }
};
