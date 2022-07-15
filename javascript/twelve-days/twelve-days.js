export const recite = (...verseNumbers) => {

    if (verseNumbers.length === 1) {
        return verse(verseNumbers[0]);
    }

    if (verseNumbers.length === 2) {
        return verses(verseNumbers[0], verseNumbers[1]);
    }

};

const verse = (verseNumber) => {
    let verseSB = '';
    let days = ['', 'first', 'second', 'third', 'fourth', 'fifth', 'sixth', 'seventh', 'eighth', 'ninth', 'tenth', 'eleventh', 'twelfth'];
    let items = ['', 'a Partridge in a Pear Tree.', 'two Turtle Doves, ', 'three French Hens, ', 'four Calling Birds, ',
        'five Gold Rings, ', 'six Geese-a-Laying, ', 'seven Swans-a-Swimming, ', 'eight Maids-a-Milking, ', 
        'nine Ladies Dancing, ', 'ten Lords-a-Leaping, ', 'eleven Pipers Piping, ', 'twelve Drummers Drumming, '];

    verseSB = verseSB.concat(`On the ${days[verseNumber]} day of Christmas my true love gave to me: `);

    for (let i = verseNumber; i > 0; i--) {
        if (i == 1 && verseNumber > 1) {
            verseSB = verseSB.concat('and ');
        }         

        verseSB = verseSB.concat(items[i]);
    }

    verseSB = verseSB.concat('\n');

    return verseSB;
};

const verses = (startVerse, endVerse) => {
    let verseSB = '';

    for (let i = startVerse; i <= endVerse; i++) {
        verseSB = verseSB.concat(verse(i));
        if (i < endVerse) {
            verseSB = verseSB.concat("\n");
        }
    }

    return verseSB;
};
