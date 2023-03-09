module RobotSimulator

type Direction = North | East | South | West
type Position = int * int

let rotateLeft robot =
    let (direction, position) = robot

    match direction with
    | North -> (West, position)
    | West -> (South, position)
    | South -> (East, position)
    | East -> (North, position)

let rotateRight robot =
    let (direction, position) = robot

    match direction with
    | North -> (East, position)
    | East -> (South, position)
    | South -> (West, position)
    | West -> (North, position)

let advance robot =
    let (direction, (x, y)) = robot

    match direction with
    | North -> (North, (x, y + 1))
    | East -> (East, (x + 1, y))
    | South -> (South, (x, y - 1))
    | West -> (West, (x - 1, y))

let execMove robot instruction =

    match instruction with
    | 'L' -> rotateLeft robot
    | 'R' -> rotateRight robot
    | 'A' -> advance robot
    | _ -> robot


let create direction position = 
    (direction, position)

let move instructions robot = 
    Seq.fold execMove robot instructions
