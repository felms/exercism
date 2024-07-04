module Raindrops (convert) where

convert :: Int -> String
convert n
    | converted == "" = show n
    | otherwise = converted
    where
        converted = concatMap mappingFunction numberMapping
        mappingFunction (number, mapping) = if n `mod` number == 0 then mapping else ""
        numberMapping = [(3, "Pling"), (5, "Plang"), (7, "Plong")]

