module StateOfTicTacToe (gameState, GameState(..)) where

data GameState = WinX | WinO | Draw | Ongoing | Impossible deriving (Eq, Show)

gameState :: [String] -> GameState
gameState board
    | impossible . concat $ board = Impossible
    | xWon . concat $ board = WinX
    | oWon . concat $ board = WinO
    | draw . concat $ board = Draw
    | otherwise = Ongoing

xWon :: String -> Bool
xWon ['X', 'X', 'X', _, _, _, _, _, _] = True
xWon [_, _, _, 'X', 'X', 'X', _, _, _] = True
xWon [_, _, _, _, _, _, 'X', 'X', 'X'] = True
xWon ['X', _, _, 'X', _, _, 'X', _, _] = True
xWon [_, 'X', _, _, 'X', _, _, 'X', _] = True
xWon [_, _, 'X', _, _, 'X', _, _, 'X'] = True
xWon ['X', _, _, _, 'X', _, _, _, 'X'] = True
xWon [_, _, 'X', _, 'X', _, 'X', _, _] = True
xWon _ = False

oWon :: String -> Bool
oWon ['O', 'O', 'O', _, _, _, _, _, _] = True
oWon [_, _, _, 'O', 'O', 'O', _, _, _] = True
oWon [_, _, _, _, _, _, 'O', 'O', 'O'] = True
oWon ['O', _, _, 'O', _, _, 'O', _, _] = True
oWon [_, 'O', _, _, 'O', _, _, 'O', _] = True
oWon [_, _, 'O', _, _, 'O', _, _, 'O'] = True
oWon ['O', _, _, _, 'O', _, _, _, 'O'] = True
oWon [_, _, 'O', _, 'O', _, 'O', _, _] = True
oWon _ = False

draw :: String -> Bool
draw board = count ' ' board == 0

impossible :: String -> Bool
impossible board
    | (count 'X' board) - (count 'O' board) > 1 = True
    | (count 'X' board) < (count 'O' board) = True
    | (xWon board) && (oWon board) = True
    | otherwise = False

count :: Char -> String -> Int
count item board = length $ filter (== item) $ board
