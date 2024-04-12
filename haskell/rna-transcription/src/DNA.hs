module DNA (toRNA) where

toRNA :: String -> Either Char String
toRNA xs = complement xs ""
    where 
        complement "" acc =  Right (reverse acc)
        complement (x:xs) acc
            | x == 'G' = complement xs ('C' : acc)
            | x == 'C' = complement xs ('G' : acc)
            | x == 'T' = complement xs ('A' : acc)
            | x == 'A' = complement xs ('U' : acc)
            | otherwise = Left x
