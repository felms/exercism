module RnaTranscription exposing (toRNA)


toRNA : String -> Result String String
toRNA dna = 
    if  not (String.all (\c -> List.member c ['G', 'C', 'T', 'A']) dna)
    then
        Err "invalid input"
    else
        dna
        |> String.map complement
        |> Ok

complement : Char -> Char
complement x = 
    case x of 
        'G' -> 'C'
        'C' -> 'G'
        'T' -> 'A'
        'A' -> 'U'
        _ -> '_'
