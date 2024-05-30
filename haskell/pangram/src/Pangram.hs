module Pangram (isPangram) where

import Data.Char

isPangram :: String -> Bool
isPangram text 
    | text == "" = False
    | otherwise = all (\letter -> letter `elem` lowerCaseText) "abcdefghijklmnopqrstuvwxyz"
        where lowerCaseText = map toLower text
