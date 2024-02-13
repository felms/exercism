using System;
using System.Collections.Generic;
using System.Linq;

public static class ProteinTranslation
{
    public static string[] Proteins(string strand)
    {

        var codonAminoacid = new Dictionary<string, string>
        { 
            {"AUG" , "Methionine"},
            {"UUU" , "Phenylalanine"},
            {"UUC" , "Phenylalanine"},
            {"UUA" , "Leucine"},
            {"UUG" , "Leucine"},
            {"UCU" , "Serine"},
            {"UCC" , "Serine"},
            {"UCA" , "Serine"},
            {"UCG" , "Serine"},
            {"UAU" , "Tyrosine"},
            {"UAC" , "Tyrosine"},
            {"UGU" , "Cysteine"},
            {"UGC" , "Cysteine"},
            {"UGG" , "Tryptophan"},
            {"UAA" , "STOP"},
            {"UAG" , "STOP"},
            {"UGA" , "STOP"}
        };


        return strand.Chunk(3)
                .Select(chunk => new string(chunk))
                .TakeWhile(codon => codonAminoacid[codon] != "STOP")
                .Select(codon => codonAminoacid[codon])
                .ToArray();
    }

}