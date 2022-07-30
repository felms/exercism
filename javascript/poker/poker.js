export const bestHands = (hands) => {

  if (hands.length === 1) {
    return hands;
  }

  let highHands = hands.filter(hand => isThreeOfAKind(hand));
  if (highHands.length > 0) {
    if (highHands.length > 1) {
      highHands = breakTieTriples(highHands);
    }

    return highHands;
  }

  highHands = hands.filter(hand => isTwoPairs(hand));
  if (highHands.length > 0) {
    if (highHands.length > 1) {
      highHands = breakTiePair(highHands);
    }

    return highHands;
  }

  highHands = hands.filter(hand => isPair(hand));
  if (highHands.length > 0) {
    if (highHands.length > 1) {
      highHands = breakTiePair(highHands);
    }

    return highHands;
  }

  return highCardHands(hands);
};

const isThreeOfAKind = (hand) => {

  // Gets the frequency of each card for the hand
  let cards = hand.replaceAll(/[SHCD]/g,'').split(' ');
  let cardFrequency = {};
  cards.forEach(card => {
    cardFrequency[card] = cardFrequency[card] ? ++cardFrequency[card] : 1;
  });

  // If some card has a frequency of three
  // the hand is a three of a kind
  let threeOAK = Object.values(cardFrequency).filter(value => value === 3);
  return threeOAK.length === 1;

}

const isTwoPairs = (hand) => {

  // Gets the frequency of each card for the hand
  let cards = hand.replaceAll(/[SHCD]/g,'').split(' ');
  let cardFrequency = {};
  cards.forEach(card => {
    cardFrequency[card] = cardFrequency[card] ? ++cardFrequency[card] : 1;
  });

  // If some card has a frequency of two
  // the hand is a pair
  let pairs = Object.values(cardFrequency).filter(value => value === 2);
  return pairs.length === 2;

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

const breakTieTriples = (hands) => {

  let h = [...hands];

  // Creates a set with all TOAK's
  // and a list of objects relating 
  // them to the hands.
  let triples = new Set();
  let handTriples = [];
  h.forEach(hand => {
    
    let objHand = {theHand: hand, theTriple: ''};

    // Gets the frequency of each card for the hand
    let cards = hand.replaceAll(/[SHCD]/g,'').split(' ');
    let cardFrequency = {};
    cards.forEach(card => {
      cardFrequency[card] = cardFrequency[card] ? ++cardFrequency[card] : 1;
    });

    //Gets the card(s) of the pair(s)
    for (let [key, value] of Object.entries(cardFrequency)) {
      if (value === 3) {
        triples.add(key);
        objHand.theTriple = key;
      }
    }

    handTriples.push(objHand);

  });

  // Filters the list for the hand(s)
  // containing the triples(s)
  let orderedTriples = [...triples].sort(compareCards).reverse();
  while(orderedTriples.length > 0) {
    let highCard = orderedTriples.shift();
    h = [...handTriples];
    h = h.filter(handTriple => handTriple.theTriple === highCard);
    if (h.length === 1) {
      return [h[0].theHand];
    }
  }

  return breakTieKicker(hands);

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

  return breakTieKicker(hands);

};

const breakTieKicker = (hands) => {

  let h = [...hands];

  // Creates a set with all 'kickers'
  // and a list of objects relating 
  // them and hands.
  let kickers = new Set();
  let handKickers = [];
  h.forEach(hand => {
    
    let objHand = {theHand: hand, theKickers: []};

    // Gets the frequency of each card for the hand
    let cards = hand.replaceAll(/[SHCD]/g,'').split(' ');
    let cardFrequency = {};
    cards.forEach(card => {
      cardFrequency[card] = cardFrequency[card] ? ++cardFrequency[card] : 1;
    });

    //Gets the card(s) of the kickers(s)
    for (let [key, value] of Object.entries(cardFrequency)) {
      if (value === 1) {
        kickers.add(key);
        objHand.theKickers.push(key);
      }
    }

    handKickers.push(objHand);

  });

  // Filters the list for the hand(s)
  // containing the kickers(s)
  let orderedKickers = [...kickers].sort(compareCards).reverse();
  while(orderedKickers.length > 0) {
    let highCard = orderedKickers.shift();
    h = [...handKickers];
    h = h.filter(handKicker => handKicker.theKickers.some(card => card === highCard));
    if (h.length === 1) {
      return [h[0].theHand];
    }
  }

  return hands;

};

const breakTie = (hands) => {

  let h = [...hands];

  let cards = h.map(hand => hand.replaceAll(/[SHCD]/g, '')).join(' ').split(' ');
  let setCards = new Set(cards);
  cards = [...setCards].sort(compareCards).reverse();

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
