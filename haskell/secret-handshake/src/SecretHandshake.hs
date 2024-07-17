module SecretHandshake (handshake) where

import Data.Bits

handshake :: Int -> [String]
handshake number 
    | number .&. 16 /= 0 = reverse $ commands commandsList number []
    | otherwise = commands commandsList number []
    where
        commandsList = [(1, "wink"), (2, "double blink"), (4, "close your eyes"), (8, "jump")]


commands :: [(Int, String)] -> Int -> [String] -> [String]
commands [] _ acc = reverse acc
commands ((code, command) : xs) number acc 
    | number .&. code /= 0 = commands xs number (command : acc) 
    | otherwise = commands xs number acc

