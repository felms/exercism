module SumOfMultiples (sumOfMultiples) where

sumOfMultiples :: [Integer] -> Integer -> Integer
sumOfMultiples factors limit =
    sum [x | x <- [1..limit - 1], any (\num -> num /= 0 && x `rem` num == 0) factors]
