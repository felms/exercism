fun append ([], ys) = ys : int list
  | append(x :: xs, ys) = x :: append(xs, ys)

fun concat ([]) = [] : int list
  | concat(x :: xs) = append(x, concat(xs))

fun do_reverse([], acc) = acc : int list
  | do_reverse(x :: xs, acc) = do_reverse(xs, x :: acc)

fun reverse (list: int list): int list =
  do_reverse(list, [])

fun filter (_, []) = [] : int list
  | filter(function, x :: xs) = 
  if function(x) 
  then x :: filter(function, xs) 
  else filter(function, xs)

fun map (_, []) = [] : int list
  | map(function, x :: xs) = function(x) :: map(function, xs)

fun length ([]) = 0 : int
  | length(_ :: xs) = 1 + length(xs)

fun foldl (_, initial, []) = initial : int
  | foldl(function, initial, x :: xs) = foldl(function, function(initial, x), xs)

fun foldr (_, initial, []) = initial : int
  | foldr(function, initial, x :: xs) = function(x, foldr(function, initial, xs))

