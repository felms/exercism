// @ts-check
//
// The line above enables type checking for this file. Various IDEs interpret
// the @ts-check directive. It will give you helpful autocompletion when
// implementing this exercise.

/**
 * Calculates the total bird count.
 *
 * @param {number[]} birdsPerDay
 * @returns {number} total bird count
 */
export function totalBirdCount(birdsPerDay) {
    return birdsPerDay.reduce((a, b) => a + b, 0);
}

/**
 * Calculates the total number of birds seen in a specific week.
 *
 * @param {number[]} birdsPerDay
 * @param {number} week
 * @returns {number} birds counted in the given week
 */
export function birdsInWeek(birdsPerDay, week) {
    let startIndex = (week - 1) * 7;

    return birdsPerDay.slice(startIndex, startIndex + 7)
                .reduce((a, b) => a + b, 0);
}

/**
 * Fixes the counting mistake by increasing the bird count
 * by one for every second day.
 *
 * @param {number[]} birdsPerDay
 * @returns {number[]} corrected bird count data
 */
export function fixBirdCountLog(birdsPerDay) {

    for (let index = 0; index < birdsPerDay.length; index++) {
        let num = birdsPerDay[index];
        birdsPerDay[index] = index % 2 == 0 ? num + 1 : num
    }

    return birdsPerDay;
}
