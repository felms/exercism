export const bestHands = (hands) => {

  if (hands.length === 1) {
    return hands;
  }

  return highCardHands(hands);
};

// Returns the highest card hand
const highCardHands = (hands) => {

  let highCard = getHighCard(hands);

  let highHands = hands.filter(hand => hand.includes(highCard));

  if (highHands.length === 1) {
    return highHands;
  }

  // Tries to break tie
  return breakTie(highHands);
};

// Returns the highest card from all hands
const getHighCard = (hands) => {

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

const breakTie = (hands) => {

  let h = [...hands];

  h = [...hands];
  h = h.filter(hand => hand.includes('A'));
  if (h.length === 1) {
    return h;
  }

  h = [...hands];
  h = h.filter(hand => hand.includes('K'));
  if (h.length === 1) {
    return h;
  }

  h = [...hands];
  h = h.filter(hand => hand.includes('Q'));
  if (h.length === 1) {
    return h;
  }

  h = [...hands];
  h = h.filter(hand => hand.includes('J'));
  if (h.length === 1) {
    return h;
  }

  h = [...hands];
  let cards = h.map(hand => hand.replaceAll(/[A-Z]/g, '')).join(' ').split(' ');
  let setCards = new Set(cards);
  cards = [...setCards].sort().reverse();

  while(cards.length > 0) {
    let highCard = cards.shift();
    h = [...hands];
    h = h.filter(hand => hand.includes(highCard));
    if (h.length === 1) {
      return h;
    }
  }

  return h;
};
