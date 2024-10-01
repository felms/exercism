module Bob

open System
open System.Text.RegularExpressions

let response (input: string): string = 
    let str = input.Trim()
    let isQuestion (input: string): bool = Regex.IsMatch(input, "^.*\?$")
    let isYelling (input: string): bool = (input = input.ToUpper()) && not (input = input.ToLower())

    match (str, isYelling(str), isQuestion(str)) with
    | ("", _, _) -> "Fine. Be that way!"
    | (_, true, true) -> "Calm down, I know what I'm doing!"
    | (_, true, false) -> "Whoa, chill out!"
    | (_, false, true) -> "Sure."
    | _ -> "Whatever."
