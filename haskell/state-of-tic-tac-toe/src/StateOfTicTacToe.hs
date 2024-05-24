module StateOfTicTacToe (gameState, GameState(..)) where

import Data.List

data GameState = WinX | WinO | Draw | Ongoing | Impossible deriving (Eq, Show)

gameState :: [String] -> GameState
gameState board
    | impossible board    = Impossible
    | playerWon 'X' board = WinX
    | playerWon 'O' board = WinO
    | draw board          = Draw
    | otherwise           = Ongoing

playerWon :: Char -> [String] -> Bool
playerWon player board = 
    let element = [player, player, player] in
        element `elem` board ||
        element `elem` transpose board ||
        element == (diagonal board) ||
        element == (diagonal $ map reverse board)

draw :: [String] -> Bool
draw board = (count ' ' board) == 0

impossible :: [String] -> Bool
impossible board
    | (count 'X' board) - (count 'O' board) > 1 = True
    | (count 'X' board) < (count 'O' board) = True
    | (playerWon 'X' board) && (playerWon 'O' board) = True
    | otherwise = False

count :: Char -> [String] -> Int
count item board = length $ filter (== item) $ concat board

diagonal :: [[a]] -> [a]
diagonal [] = []
diagonal (x : xs) = head x : (diagonal $ map tail xs)
