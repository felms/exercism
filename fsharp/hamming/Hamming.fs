module Hamming

let distance (strand1: string) (strand2: string): int option = 

    if String.length strand1 <> String.length strand2 then
        None
    else
    Seq.zip strand1 strand2
    |> Seq.map(fun (a, b) -> 
        if a = b then
            0
        else
            1
    )
    |> Seq.sum
    |> Some