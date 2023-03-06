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

let rec do_translate (input, acc) = 

    match input with
    | [] -> acc
    | x :: xs -> 
        match of_codon x with 
        | "STOP" -> acc
        | codon -> do_translate(xs, acc @ [codon])

let translate(input) = do_translate(input, [])

let proteins rna = 

    match rna with
    | "" -> []
    | protein -> protein 
                            |> Seq.toList 
                            |> Seq.chunkBySize(3) 
                            |> Seq.map(fun s -> new string(s)) 
                            |> Seq.toList
                            |> translate
    


 // let proteins rna = failwith "You need to implement this function."


