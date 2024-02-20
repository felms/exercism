pub fn append(first first: List(a), second second: List(a)) -> List(a) {
  case first, second {
    [head, ..tail], second -> [head, ..append(tail, second)]
    [], _ -> second
  }

}

pub fn concat(lists: List(List(a))) -> List(a) {
  case lists {
    [] -> []
    [head, ..tail] -> append(head, concat(tail))
  }
}

pub fn filter(list: List(a), function: fn(a) -> Bool) -> List(a) {
  case list {
    [] -> []
    [head, ..tail] -> {
      case function(head) {
        True -> [head, ..filter(tail, function)]
        False -> filter(tail, function)
      }
    }
  }
}


pub fn length(list: List(a)) -> Int {
  case list {
    [_head, ..rest] -> 1 + length(rest)
    _ -> 0
  }
}

pub fn map(list: List(a), function: fn(a) -> b) -> List(b) {
  case list {
    [head, ..tail] -> [function(head), ..map(tail, function)]
    _ -> []
  }
}

pub fn foldl(
  over list: List(a),
  from initial: b,
  with function: fn(b, a) -> b,
) -> b {
  case list {
    [] -> initial 
    [head, ..tail] -> foldl(tail, function(initial, head), function)
  }
}

pub fn foldr(
  over list: List(a),
  from initial: b,
  with function: fn(b, a) -> b,
) -> b {
  reverse(list)
  |> foldl(initial, function)
}

pub fn reverse(list: List(a)) -> List(a) {
  do_reverse(list, [])
}

fn do_reverse(list: List(a), acc: List(a)) -> List(a) {
  case list {
    [head, ..tail] -> do_reverse(tail, [head, ..acc])
    _ -> acc
  }
}
