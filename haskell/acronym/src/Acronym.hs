module Acronym (abbreviate) where

import Data.Char
import Data.List

abbreviate :: String -> String
abbreviate xs = intercalate "" (map (take 1) (split xs))

split :: String -> [String]
split phrase = words (map cleanup (padCamelCase phrase))

cleanup :: Char -> Char
cleanup '-' = ' '
cleanup '_' = ' '
cleanup c = toUpper c

padCamelCase :: String -> String
padCamelCase "" = ""
padCamelCase (x : y : xs)
    | isLower x && isUpper y = x : ' ' : padCamelCase(y : xs)
    | otherwise = x : padCamelCase(y : xs)
padCamelCase (x : xs) = x : padCamelCase(xs)
