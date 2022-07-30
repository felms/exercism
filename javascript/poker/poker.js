export const bestHands = (hands) => {

  if (hands.length === 1) {
    return hands;
  }

  return highCardHands(hands);
};

// Returns the highest card hand
const highCardHands = (hands) => {

  let highestCard = highCard(hands);
  let highHands = [];

  hands.forEach(hand => {
    if (hand.includes(highestCard)) {
      highHands.push(hand);
    }
  });

  console.log('HCard: ' + highestCard);
  console.log('HHand: ' + highHands);
  return highHands;
};

// Returns the highest card from all hands
const highCard = (hands) => {

  let allCards = hands.join(' ');

  // If theres 'royal' card
  if (allCards.includes('A')) {
    return 'A';
  } 

  if (allCards.includes('K')) {
    return 'K';
  } 

  if (allCards.includes('Q')) {
    return 'Q';
  } 

  if (allCards.includes('J')) {
    return 'J';
  }

  let numbers = allCards.replaceAll(/[A-Z]/g, '')
    .split(' ')
    .map(number => parseInt(number));

  return Math.max(...numbers).toString();

};
