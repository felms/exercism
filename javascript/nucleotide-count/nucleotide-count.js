export function countNucleotides(strand) {

    if (strand.length && strand.match(/[^ACGT]/)) {
        throw new Error('Invalid nucleotide in strand');
    }

    const counts = { 'A': 0, 'C': 0, 'G': 0, 'T': 0 };

    [...strand].forEach(nucleotide => counts[nucleotide]++);

    return `${ counts['A'] } ${ counts['C'] } ${ counts['G'] } ${ counts['T'] }`;
}
