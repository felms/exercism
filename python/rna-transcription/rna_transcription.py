transcription = {
   "G": "C",
   "C": "G",
   "T": "A",
   "A": "U"
}


def to_rna(dna_strand):

    res = []
    for nucleotide in dna_strand:
        res.append(transcription[nucleotide])

    return "".join(res)
