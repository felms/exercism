const complement = {'G':'C', 'C':'G', 'T':'A', 'A':'U'};

export const toRna = (dna) => {
    return [...dna].map(nucleotide => complement[nucleotide]).join('');
};
