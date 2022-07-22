export const translate = (codon = '') => {

  let proteins = {
    'AUG': 'Methionine',
    'UUU': 'Phenylalanine',
    'UUC': 'Phenylalanine',
    'UUA': 'Leucine',
    'UUG': 'Leucine',
    'UCU': 'Serine',
    'UCC': 'Serine',
    'UCA': 'Serine',
    'UCG': 'Serine',
    'UAU': 'Tyrosine',
    'UAC': 'Tyrosine',
    'UGU': 'Cysteine',
    'UGC': 'Cysteine',
    'UGG': 'Tryptophan',
    'UAA': 'STOP',
    'UAG': 'STOP',
    'UGA': 'STOP'
  };

  let sequences = splitSequence(codon);

  let ans = [];

  for (let s of sequences) {
    let protein = proteins[s];

    if (!protein) {
      throw new Error('Invalid codon');
    }

    if (protein === 'STOP') {
      break;
    }

    ans.push(protein);
  }

  return ans;

};

const splitSequence = (sequence) => {
  let values = [];
  let seq = sequence.split('');

  for (let i = 0; i < seq.length; i += 3) {
    values.push(seq.slice(i, i + 3).join(''));
  }

  return values;
};
