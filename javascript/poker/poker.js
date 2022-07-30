export const bestHands = (hands) => {

  if (hands.length === 1) {
    return hands;
  }

  let highHands = hands.filter(hand => isPair(hand));

  if (highHands.length > 0) {
    if (highHands.length > 1) {
      highHands = breakTiePair(highHands);
    }

    return highHands;
  }

  return highCardHands(hands);
};

const isPair = (hand) => {

  // Gets the frequency of each card for the hand
  let cards = hand.replaceAll(/[SHCD]/g,'').split(' ');
  let cardFrequency = {};
  cards.forEach(card => {
    cardFrequency[card] = cardFrequency[card] ? ++cardFrequency[card] : 1;
  });

  // If some card has a frequency of two
  // the hand is a pair
  let frequency = Object.values(cardFrequency);
  return frequency.includes(2);

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

  let allCards = hands.join(' ').replace(/[SHCD]/g,'').split(' ');

  return highCardFromList(allCards);

};

const breakTiePair = (hands) => {

  let h = [...hands];

  // Creates a set with all pairs
  // and a list of objects relating 
  // pairs and hands.
  let pairs = new Set();
  let handPairs = [];
  h.forEach(hand => {
    
    let objHand = {theHand: hand, thePairs: []};

    // Gets the frequency of each card for the hand
    let cards = hand.replaceAll(/[SHCD]/g,'').split(' ');
    let cardFrequency = {};
    cards.forEach(card => {
      cardFrequency[card] = cardFrequency[card] ? ++cardFrequency[card] : 1;
    });

    //Gets the card(s) of the pair(s)
    for (let [key, value] of Object.entries(cardFrequency)) {
      if (value === 2) {
        pairs.add(key);
        objHand.thePairs.push(key);
      }
    }

    handPairs.push(objHand);

  });

  // Filters the list for the hand(s)
  // containing the pair(s)
  let orderedPairs = [...pairs].sort(compareCards).reverse();
  while(orderedPairs.length > 0) {
    let highCard = orderedPairs.shift();
    h = [...handPairs];
    h = h.filter(handPair => handPair.thePairs.some(card => card === highCard));
    if (h.length === 1) {
      return [h[0].theHand];
    }
  }

  return breakTie(hands);

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

// Returns the highest card from a list
const highCardFromList = (cards) => {

  let sortedCards = cards.sort(compareCards).reverse();
  return sortedCards[0];

};

// Compare function for cards
const compareCards = (cardA, cardB) => {

  if (cardA === cardB) {
    return 0;
  }

  if (cardA === 'A' && cardB !== 'A') {
    return 1;
  } else if (cardB === 'A' && cardA !== 'A') {
    return -1;
  } else if (cardA === 'K' && cardB !== 'K') {
    return 1;
  } else if (cardB === 'K' && cardA !== 'K') {
    return -1;
  } else if (cardA === 'Q' && cardB !== 'Q') {
    return 1;
  } else if (cardB === 'Q' && cardA !== 'Q') {
    return -1;
  } else if (cardA === 'J' && cardB !== 'J') {
    return 1;
  } else if (cardB === 'J' && cardA !== 'J') {
    return -1;
  }

  let a = parseInt(cardA);
  let b = parseInt(cardB);

  return a - b;
}; 
