module Yacht

type Category = 
    | Ones
    | Twos
    | Threes
    | Fours
    | Fives
    | Sixes
    | FullHouse
    | FourOfAKind
    | LittleStraight
    | BigStraight
    | Choice
    | Yacht

type Die =
    | One 
    | Two 
    | Three
    | Four 
    | Five 
    | Six

let dice_sum dice =
    dice |> Seq.map(fun die -> 
        match die with
        | Die.One -> 1
        | Die.Two -> 2
        | Die.Three -> 3
        | Die.Four -> 4
        | Die.Five -> 5
        | Die.Six -> 6
    ) |> Seq.sum

let count dice die number =
    let scored = dice |> Seq.filter (fun x -> x = die) |> Seq.length 
    scored * number

let score_yacht dice =
    let distinct = dice |> Seq.distinct |> Seq.length
    if distinct = 1 then 50 else 0

let score_full_house dice =
    match List.sort(dice) with
    | [a; b; c; d; e] when a = b && a <> c && c = d && d = e -> dice_sum dice
    | [a; b; c; d; e] when a = b && b = c && c <> d && d = e -> dice_sum dice
    | _ -> 0

let score_four_of_a_kind dice =
    match List.sort(dice) with
    | [a; b; c; d; e] when a <> b && b = c && c = d && d = e -> dice_sum [b; c; d; e]
    | [a; b; c; d; e] when a = b && b = c && c = d && d <> e -> dice_sum [a; b; c; d]
    | [a; b; c; d; e] when a = b && b = c && c = d && d = e -> dice_sum [a; b; c; d]
    | _ -> 0

let score_little_straight dice = 
    match List.sort(dice) with
    | [Die.One; Die.Two; Die.Three; Die.Four; Die.Five] -> 30
    | _ -> 0

let score_big_straight dice = 
    match List.sort(dice) with
    | [Die.Two; Die.Three; Die.Four; Die.Five; Die.Six] -> 30
    | _ -> 0


    
let score category dice = 
    match category with
    | Category.Yacht -> score_yacht dice
    | Category.FullHouse -> score_full_house dice
    | Category.FourOfAKind-> score_four_of_a_kind dice
    | Category.LittleStraight -> score_little_straight dice
    | Category.BigStraight -> score_big_straight dice
    | Category.Choice -> dice_sum dice
    | Category.Ones -> count dice Die.One 1 
    | Category.Twos -> count dice Die.Two 2
    | Category.Threes -> count dice Die.Three 3
    | Category.Fours -> count dice Die.Four  4
    | Category.Fives -> count dice Die.Five 5
    | Category.Sixes -> count dice Die.Six 6
