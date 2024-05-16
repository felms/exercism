module Hamming (distance) where

distance :: String -> String -> Maybe Int
distance xs ys
    | length xs /= length ys = Nothing
    | otherwise = Just (dist xs ys)
    where
        dist "" "" = 0
        dist (x:xs) (y:ys) = (if x == y then 0 else 1) + (dist xs ys)
        
