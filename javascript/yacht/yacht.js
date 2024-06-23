export const score = (dice, category) => {
    const scoreFunctionMap = {
        'ones': (rolls) => numberCategories(1, rolls),
        'twos': (rolls) => numberCategories(2, rolls),
        'threes': (rolls) => numberCategories(3, rolls),
        'fours': (rolls) => numberCategories(4, rolls),
        'fives': (rolls) => numberCategories(5, rolls),
        'sixes': (rolls) => numberCategories(6, rolls),
        'full house': fullHouse,
        'four of a kind': fourOfAKind,
        'little straight': littleStraight,
        'big straight': bigStraight,
        'choice': choice,
        'yacht': yacht,
    };

    return scoreFunctionMap[category](dice);
};

const numberCategories = (number, dice) => number * freqNumber(dice, number);

const fullHouse = (dice) => isFullHouse(dice) 
            ? dice.reduce((a, b) => a + b, 0) : 0;

const fourOfAKind = (dice) => 
    4 * ((dice.find(number => freqNumber(dice, number) >= 4)) ?? 0);

const littleStraight = (dice) => 
    JSON.stringify(sortArray(dice)) === '[1,2,3,4,5]' ? 30 : 0;

const bigStraight = (dice) => 
    JSON.stringify(sortArray(dice)) === '[2,3,4,5,6]' ? 30 : 0;

const choice = (dice) => dice.reduce((a, b) => a + b);

const isFullHouse = (dice) => 
    dice.some(number => freqNumber(dice, number) === 3)
    && dice.some(number => freqNumber(dice, number) === 2);

const yacht = (dice) => 
    dice.some(number => freqNumber(dice, number) === 5) ? 50 : 0;

const freqNumber = (dice, number) => dice.filter(n => number === n).length;

const sortArray = (array) => array.sort((a, b) => a - b);
