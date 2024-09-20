let isAnagram = (word, candidate) => {
    let upperWord = word |> String.uppercase_ascii;
    let upperCandidate = candidate |> String.uppercase_ascii;

    let sortedWord = upperWord |> Js.String.split("") |> Js.Array.sortInPlace |> Js.Array.joinWith("");
    let sortedCandidate = upperCandidate |> Js.String.split("") |>  Js.Array.sortInPlace |> Js.Array.joinWith("");

    (upperWord != upperCandidate) && (sortedWord == sortedCandidate);
};

let anagrams = (word, candidates) => 
    candidates |> List.filter(w => isAnagram(word, w));

