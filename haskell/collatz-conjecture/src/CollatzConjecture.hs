module CollatzConjecture (collatz) where

collatz :: Integer -> Maybe Integer
collatz n 
    | n > 0 = Just (collatzConj 0 n)
    | otherwise = Nothing
    where
        collatzConj steps 1 = steps
        collatzConj steps n = collatzConj (1 + steps) (if even n then n `div` 2 else 3 * n + 1)
