codons = {
    "UGU" : "Cysteine",
    "UGC" : "Cysteine",
    "UUA" : "Leucine",
    "UUG" : "Leucine",
    "AUG" : "Methionine",
    "UUU" : "Phenylalanine",
    "UUC" : "Phenylalanine",
    "UCU" : "Serine",
    "UCC" : "Serine",
    "UCA" : "Serine",
    "UCG" : "Serine",
    "UGG" : "Tryptophan",
    "UAU" : "Tyrosine",
    "UAC" : "Tyrosine",
    "UAA" : "STOP",
    "UAG" : "STOP",
    "UGA" : "STOP"
}

def proteins(strand):

    res = []

    for i in range(0, len(strand), 3):
        s = strand[i : i + 3] 
        translated = codons[s]
        if translated == "STOP":
            break

        res.append(translated)

    return res
