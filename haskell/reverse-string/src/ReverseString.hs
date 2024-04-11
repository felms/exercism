module ReverseString (reverseString) where

reverseString :: String -> String
reverseString str = rev str []

rev :: String -> String -> String
rev [] res = res
rev (x:xs) res = rev xs (x:res)
