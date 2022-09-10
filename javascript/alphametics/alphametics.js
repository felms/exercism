let puzzleSolution;

export const solve = (puzzle) => {

  puzzleSolution = {};

  let [operation, result] = puzzle.split(' == ');
  let terms = operation.split(' + ');

  let letters = puzzle.split('').filter(letter => letter !== ' ' && letter !== '=' && letter !== '+');
  letters = Array.from(new Set(letters));

  let numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
  let solution = {};

  solvePuzzle(terms, result, letters, numbers, solution);

  return Object.keys(puzzleSolution).length > 0 ? puzzleSolution : null;

};

// mapeia a solução para os termos dados e 
// testa se essa é uma solução válida
const validSolution = (terms, result, solution) => {

  let newTerms = terms.map(term => parseInt(term.split('').map(l => solution[l]).join('')));
  let newResult = parseInt(result.split('').map(l => solution[l]).join(''));

  return newTerms.reduce((acc, i) => i + acc, 0) === newResult;
};


// gera todas as soluções possíveis com backtracking

const solvePuzzle = (terms, result, remainingLetters, remainingNumbers, currentSolution) => {

  // --- Caso base --- 
  // Qto foram colocados candidatos para 
  // todas as letras do quebra-cabeças
  // testamos se essa é uma solução válida
  if (remainingLetters.length === 0) {

    if (validSolution(terms, result, currentSolution)) {
      puzzleSolution = JSON.parse(JSON.stringify(currentSolution));
      return true;
    }

    return false;
  }

  // --- Caso recursivo ---
  // Para cada uma das letras ainda não 
  // testadas procura-se um número candidato
  // com backtracking

  let letter = remainingLetters.shift();

  for (let i = 0; i < remainingNumbers.length; i++) {

    let [number] = remainingNumbers.splice(i, 1);
    let newSolution = JSON.parse(JSON.stringify(currentSolution));
    newSolution[letter] = number;

    if (solvePuzzle(terms, result, remainingLetters, remainingNumbers, newSolution)) {
      currentSolution = JSON.parse(JSON.stringify(newSolution));
      console.log('DEU CERTO: ' + JSON.stringify(currentSolution));
      return true;
    }

    remainingNumbers.splice(i, 0, number);

  }

  remainingLetters.unshift(letter);

}; 
