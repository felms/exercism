module CollatzConjecture

let steps (number: int): int option =
    let rec collatz (number: int, steps: int): int option =
        match number with
        | 1 -> Some (steps)
        | x when x < 1 -> None
        | x when x % 2 = 0 -> collatz (x / 2, steps + 1)
        | x when x % 2 = 1 -> collatz (3 * x + 1, steps + 1)
        | _ -> None

    collatz(number, 0)
