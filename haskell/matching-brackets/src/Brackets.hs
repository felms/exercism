module Brackets (arePaired) where

arePaired :: String -> Bool
arePaired xs = paired (filter (\x -> x `elem` ['(', '[', '{', ')', ']', '}']) xs) "" 

paired :: String -> String -> Bool
paired [] [] = True
paired [] _  = False
paired ('(' : xs) stack = paired xs ('(' : stack)
paired ('[' : xs) stack = paired xs ('[' : stack)
paired ('{' : xs) stack = paired xs ('{' : stack)
paired (')' : xs) ('(' : ys) = paired xs ys
paired (']' : xs) ('[' : ys) = paired xs ys
paired ('}' : xs) ('{' : ys) = paired xs ys
paired _ _ = False

