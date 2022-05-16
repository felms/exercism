export function countNucleotides(strand) {
  if (strand.match(/\b[ACGT]+\b/) || strand === '') {
    let frequencies = strand.split('').reduce((total, letter) => {
      total[letter] ? total[letter]++ : total[letter] = 1;
      return total;
    }, {});

    let A = frequencies['A'] ? frequencies['A'] : 0;
    let C = frequencies['C'] ? frequencies['C'] : 0; 
    let G = frequencies['G'] ? frequencies['G'] : 0;
    let T = frequencies['T'] ? frequencies['T'] : 0;  
  
    return `${A} ${C} ${G} ${T}`;
    
  }

  throw new Error('Invalid nucleotide in strand');
}
