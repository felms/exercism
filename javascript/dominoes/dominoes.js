let dominoChain;
export const chain = (dominoes) => {

  dominoChain = [];

  if (dominoes.length === 0) {
    return dominoChain;
  }

  let remainingDominoes = [...dominoes];
  let currentChain = [];
  if (!formChain(currentChain, remainingDominoes)) {
    return null;
  }

  let firstDomino = dominoChain[0];
  let lastDomino = dominoChain[dominoChain.length - 1];
  if (firstDomino[0] !== lastDomino[1] 
    || dominoChain.length !== dominoes.length) {
    return null;
  }

  return dominoChain;
};

const formChain = (currentChain, remainingDominoes) => {

  // Retorna caso tenha conseguido inserir
  // todos os dominós
  if (remainingDominoes.length === 0) {
    dominoChain = [...currentChain];
    return true;
  }

  // Tenta todos os dominós um por um
  for (let i = 0; i < remainingDominoes.length; i++) {
    let [domino] = remainingDominoes.splice(i, 1);
    let newChain = [...currentChain];

    // Tenta inserir um dominó
    if (insertInChain(newChain, domino)) {
      if (formChain(newChain, remainingDominoes)) {
        return true;
      }
    }

    // Caso chegue a um dead end desfaz o que foi feito
    // nessa iteração e parte para a próxima
    remainingDominoes.splice(i, 0, domino);
  }

  // Passou todos as possibilidades e não
  // conseguiu criar: falha
  return false;
};

// Insere um dominó na lista fornecida
const insertInChain = (chainToInsert, domino) => {

  if (chainToInsert.length === 0) {
    chainToInsert.push(domino);
    return true;
  }

  // Tenta inserir o dominó
  let firstDomino = chainToInsert[0];
  if (domino[1] === firstDomino[0]) {
    chainToInsert.unshift(domino);
    return true;
  }

  let lastDomino = chainToInsert[chainToInsert.length - 1];
  if (lastDomino[1] === domino[0]) {
    chainToInsert.push(domino);
    return true;
  }

  // Inverte o dominó e tentar inserir assim
  domino = flipDomino(domino);
  if (domino[1] === firstDomino[0]) {
    chainToInsert.unshift(domino);
    return true;
  }

  if (lastDomino[1] === domino[0]) {
    chainToInsert.push(domino);
    return true;
  }

  return false;
};

const flipDomino = (domino) => {

  let [left, right] = domino;

  let newDomino = [];
  newDomino.push(right);
  newDomino.push(left);

  return newDomino;

};

