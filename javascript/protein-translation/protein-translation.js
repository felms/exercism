let CODON_AMINOACID = {
    "AUG" : "Methionine",
    "UUU" : "Phenylalanine",
    "UUC" :	"Phenylalanine",
    "UUA" : "Leucine",
    "UUG" : "Leucine",
    "UCU" : "Serine",
    "UCC" : "Serine",
    "UCA" : "Serine",
    "UCG" : "Serine",
    "UAU" : "Tyrosine",
    "UAC" : "Tyrosine",
    "UGU" : "Cysteine",
    "UGC" : "Cysteine",
    "UGG" :	"Tryptophan"
};

let STOP_CODONS = ["UAA", "UAG", "UGA"];

export const translate = (protein) => {
    
    let translation = [];

    for (let chunk of chunkString(protein, 3)) {

        if (!(chunk in CODON_AMINOACID) && !STOP_CODONS.includes(chunk)){
            throw new Error("Invalid codon");
        }

        if (STOP_CODONS.includes(chunk)) {
            break;
        }

        translation.push(CODON_AMINOACID[chunk]);
    }

    return translation;
};

const chunkString = (inputString, chunkLength) => {
    return inputString 
        ? inputString.match(new RegExp(".{1," + chunkLength + "}", "g")) 
        : [];
};
