import gleam/list
import gleam/string

pub type Robot {
  Robot(direction: Direction, position: Position)
}

pub type Direction {
  North
  East
  South
  West
}

pub type Position {
  Position(x: Int, y: Int)
}

pub fn create(direction: Direction, position: Position) -> Robot {
  Robot(direction, position)
}

pub fn move(
  direction: Direction,
  position: Position,
  instructions: String,
) -> Robot {
  exec_instructions(direction, position, instructions |> string.to_graphemes())
}

fn exec_instructions(direction: Direction, position: Position, instructions: List(String)) {
    case instructions {
        ["R", ..rest] -> turn_right(direction) |> exec_instructions(position, rest)
        ["L", ..rest] -> turn_left(direction) |> exec_instructions(position, rest)
        ["A", ..rest] -> exec_instructions(direction, advance(direction, position), rest)
        _ -> create(direction, position)
    }
}

fn turn_right(direction: Direction) {
    case direction {
        North -> East
        East -> South
        South -> West
        West -> North
    }
}

fn turn_left(direction: Direction) {
    case direction {
        North -> West
        West -> South
        South -> East
        East -> North
    }
}

fn advance(direction: Direction, position: Position) {
    let Position(x, y) = position
    case direction {
        North -> Position(x, y + 1)
        East -> Position(x + 1, y)
        South -> Position(x, y - 1)
        West -> Position(x - 1, y)
    }
}
