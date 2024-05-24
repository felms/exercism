module Bob (responseFor) where

import Data.Char

responseFor :: String -> String
responseFor xs
    | all isSpace xs = "Fine. Be that way!"
    | isQuestion xs && isShouting xs = "Calm down, I know what I'm doing!"
    | isQuestion xs = "Sure."
    | isShouting xs = "Whoa, chill out!"
    | otherwise = "Whatever."

isQuestion :: String -> Bool
isQuestion message = (last . trim $ message) == '?'
    where 
        trim input = filter (not . isSpace) input 

isShouting :: String -> Bool 
isShouting message = all isUpper cleanedMessage && any isUpper cleanedMessage
    where 
        cleanedMessage = filter isLetter message

