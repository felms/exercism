/// <reference path="./global.d.ts" />
// @ts-check

/**
 * Implement the functions needed to solve the exercise here.
 * Do not forget to export them so they are available for the
 * tests. Here an example of the syntax as reminder:
 *
 * export function yourFunction(...) {
 *   ...
 * }
 */


/**
 * Determine whether the lasagna is done.
 *
 * @param {number} remainingtime  the remaining time on the timer in minutes.
 * @returns {string} whether the lasagna is done
 */
 export function cookingStatus(remainingtime) {
    if (remainingtime === undefined) {
        return "You forgot to set the timer.";
    }

    if (remainingtime === 0) {
        return "Lasagna is done.";
    }

    if (remainingtime > 0) {
        return "Not done, please wait.";
    }
 }


/**
 *  Estimate the preparation time.
 *
 * @param {array} layers  the layers of the lasagne.
 * @param {number} averagePerLayer  the average preparation time per layer in minutes.
 * @returns {number} the estimate for the total preparation time based on the number of layers.
 */
 export function preparationTime(layers, averagePerLayer) {

    let timePerLayer = averagePerLayer === undefined ? 2 : averagePerLayer;

    return layers.length * timePerLayer;
 }


 /**
 *  Compute the amounts of noodles and sauce needed.
 *
 * @param {array} layers  the layers of the lasagne.
 * @returns {object} an object with keys noodles and sauce.
 */
 export function quantities(layers) {

    let noodleTotal = 0;
    let sauceTotal = 0.0;

    for (let i = 0; i < layers.length; i++) {
        if(layers[i] === "noodles") {
            noodleTotal += 50;
        }

        if (layers[i] === "sauce") {
            sauceTotal += 0.2;
        }
    }

    return {noodles: noodleTotal, sauce: sauceTotal};
 }

 /**
 *  Add the secret ingredient
 *
 * @param {array} friendsList  the list of ingredients your friend sent you.
 * @param {array} myList   your list of ingredients.
 */
 export function addSecretIngredient(friendsList, myList) {

    let secretIngredient = friendsList[friendsList.length - 1];
    myList.push(secretIngredient);
 }

  /**
 *  Add the secret ingredient
 *
 * @param {object} recipe  object that holds the amounts needed for 2 portions.
 * @param {number} portions  the number of portions you want to cook.
 * @returns {object} object with the amounts needed for the desired number of portions.
 */
 export function scaleRecipe(recipe, portions) {
    
    let portionedRecipe = {...recipe};
    
    if (portions === undefined) {
        return portionedRecipe;
    }

    let mult = portions / 2.0;

    for (let key in portionedRecipe) {
        portionedRecipe[key] *= mult;
    }


    return portionedRecipe;
    
 }