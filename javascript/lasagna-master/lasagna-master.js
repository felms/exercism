/**
 * Determine whether the lasagna is done.
 *
 * @param {number} remainingTime the remaining time on the timer in minutes.
 * @returns {string} whether the lasagna is done
 */
export const cookingStatus = (remainingTime) => {
    return remainingTime === undefined ? 'You forgot to set the timer.'
            : remainingTime === 0 ? 'Lasagna is done.'
            : 'Not done, please wait.';
};

/**
 *  Estimate the preparation time.
 *
 * @param {array} layers  the layers of the lasagne.
 * @param {number} averagePrepTimePerLayer the average preparation time per layer in minutes.
 * @returns {number} the estimate for the total preparation time based on the number of layers.
 */
export const preparationTime = (layers, averagePrepTimePerLayer = 2) => {
    return layers.length * averagePrepTimePerLayer;
};

/**
 *  Compute the amounts of noodles and sauce needed.
 *
 * @param {array} layers  the layers of the lasagne.
 * @returns {object} an object with keys noodles and sauce.
 */
export const quantities = (layers) => {
    return {
        noodles: layers.filter(layer => layer === 'noodles').length * 50,
        sauce: layers.filter(layer => layer === 'sauce').length * 0.2
    };
};

/**
 *  Add the secret ingredient
 *
 * @param {array} friendsList  the list of ingredients your friend sent you.
 * @param {array} myList   your list of ingredients.
 */
export const addSecretIngredient = (friendsList, myList) => {
    myList.push(friendsList.at(-1));
};

/**
 *  Scale the recipe
 *
 * @param {object} recipe  object that holds the amounts needed for 2 portions.
 * @param {number} numberOfPortions the number of portions you want to cook.
 * @returns {object} object with the amounts needed for the desired number of portions.
 */
export const scaleRecipe = (recipe, numberOfPortions) => {
    let multiplier = numberOfPortions / 2;

    return Object.entries(recipe)
            .reduce((acc, [key, value]) => ({...acc, [key]: value * multiplier}), {});
};
