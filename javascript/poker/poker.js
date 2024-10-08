const [HIGH_CARD, ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH] = [0, 1, 2, 3, 4, 5, 6, 7, 8];

export const bestHands = (hands) => {
    if (hands.length === 1) {
        return hands;
    }

    let highestClassification = hands.map(classifyHand).toSorted((a, b) => b - a)[0];

    let highestHands = hands.filter(hand => classifyHand(hand) === highestClassification);

    if (highestHands.length === 1) {
        return highestHands;
    }

    return breakTie(highestHands, highestClassification);

};

const classifyHand = (hand) => {

    let parsedHand = parseHand(hand);

    if (isStraight(parsedHand) && isFlush(parsedHand)) {
        return STRAIGHT_FLUSH;
    }

    let freqs = frequencies(parsedHand.map(c => c.rank)).toString();

    if (freqs === '4,1') {
        return FOUR_OF_A_KIND;
    }

    if (freqs === '3,2') {
        return FULL_HOUSE;
    }

    if (isFlush(parsedHand)) {
        return FLUSH;
    }

    if (isStraight(parsedHand)) {
        return STRAIGHT;
    }

    if (freqs === '3,1,1') {
        return THREE_OF_A_KIND;
    }

    if (freqs === '2,2,1') {
        return TWO_PAIR;
    }

    if (freqs === '2,1,1,1') {
        return ONE_PAIR;
    }

    return HIGH_CARD;
};

const breakTie = (hands, classification) => {

    if (classification === FOUR_OF_A_KIND || classification === FULL_HOUSE) {
        return breakTieFH4AK(hands);
    }

    if (classification === STRAIGHT) {
        return breakTieStraight(hands);
    }

    return sortHighCard(hands, 0);
};

const sortHighCard = (hands, pos) => {

    if (pos === 5 || hands.length === 1) {
        return hands;
    }

    let highestNthCards = hands.map(hand => sortCards(parseHand(hand))[pos]);
    let highestNthRank = sortCards(highestNthCards)[0].rank;

    let filteredHands = hands.filter(hand => sortCards(parseHand(hand))[pos].rank === highestNthRank);

    return sortHighCard(filteredHands, pos + 1);

};

const parseHand = (hand) => hand.split(' ').map(parseCard);

const parseCard = (card) => {
    let rank = 0;
    let {r, s} = /^(?<r>\d+|[AJQK])(?<s>[SHDC])$/.exec(card).groups;

    switch(r) {
        case 'A':
            rank = 14;
            break;
        case 'J':
            rank = 11;
            break;
        case 'Q':
            rank = 12;
            break;
        case 'K':
            rank = 13;
            break;
        default:
            rank = Number(r);
            break;
    }

    return {rank, suit: s};
};

const sortCards = (cards) => cards.toSorted((cardA, cardB) => cardB.rank - cardA.rank);

const isFlush = (hand) => new Set(hand.map(c => c.suit)).size === 1;

const isStraight = (hand) => {
    let sortedRanks = sortCards(hand).map(c => c.rank);

    return (sortedRanks[0] === 14 && isDecreasingSequence(sortedRanks.slice(1)))
            || isDecreasingSequence(sortedRanks);
};

const isDecreasingSequence = (numbers) => 
    numbers.length < 2 
        || ((numbers[0] - numbers[1] === 1) && isDecreasingSequence(numbers.slice(1)));

const frequencies = (numbers) => 
        [...numbers
            .reduce((acc, number) => acc.set(number, (acc.get(number) || 0) + 1), new Map())
            .values()].toSorted((a, b) => b - a);

const breakTieFH4AK = (hands) => {
    const sumOfHand = (hand) => parseHand(hand).reduce((acc, card) => acc + card.rank, 0);
    return [hands.toSorted((handA, handB) => sumOfHand(handB) - sumOfHand(handA))[0]];
};

const breakTieStraight = (hands) => {
    const secondCard = (hand) => sortCards(parseHand(hand))[1].rank;
    return [hands.toSorted((handA, handB) => secondCard(handB) - secondCard(handA))[0]];
};
