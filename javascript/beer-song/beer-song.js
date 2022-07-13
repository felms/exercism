export const recite = (initialBottlesCount, takeDownCount) => {
    let string = [];

    for(let i = initialBottlesCount; i > initialBottlesCount - takeDownCount; i--) {
        if (i === 1) {
            string.push('1 bottle of beer on the wall, 1 bottle of beer.');
            string.push('Take it down and pass it around, no more bottles of beer on the wall.');
        } else if (i == 0) {
            string.push('No more bottles of beer on the wall, no more bottles of beer.');
            string.push('Go to the store and buy some more, 99 bottles of beer on the wall.');
        } else {
            let b = i > 2 ? 'bottles' : 'bottle';
            string.push(`${i} bottles of beer on the wall, ${i} bottles of beer.`);
            string.push(`Take one down and pass it around, ${i - 1} ${b} of beer on the wall.`);
        }

        string.push('');
    }

    string.pop();
    return string;
};
