module ProteinTranslation


let of_codon codon =
    match codon with
    | "UGU" -> "Cysteine"
    | "UGC" -> "Cysteine"
    | "UUA" -> "Leucine"
    | "UUG" -> "Leucine"
    | "AUG" -> "Methionine"
    | "UUU" -> "Phenylalanine"
    | "UUC" -> "Phenylalanine"
    | "UCU" -> "Serine"
    | "UCC" -> "Serine"
    | "UCA" -> "Serine"
    | "UCG" -> "Serine"
    | "UGG" -> "Tryptophan"
    | "UAU" -> "Tyrosine"
    | "UAC" -> "Tyrosine"
    | "UAA" -> "STOP"
    | "UAG" -> "STOP"
    | "UGA" -> "STOP"
    | _ -> ""

let proteins rna = 

    rna 
    |> Seq.chunkBySize(3) 
    |> Seq.map(fun s -> new string(s) |> of_codon) 
    |> Seq.takeWhile((<>) "STOP")
    |> Seq.toList
    


 // let proteins rna = failwith "You need to implement this function."


