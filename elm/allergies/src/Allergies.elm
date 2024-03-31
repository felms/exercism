module Allergies exposing (Allergy(..), isAllergicTo, toList)

import Bitwise

type Allergy
    = Eggs
    | Peanuts
    | Shellfish
    | Strawberries
    | Tomatoes
    | Chocolate
    | Pollen
    | Cats

allergens : List Allergy
allergens = 
    [ Eggs, Peanuts, Shellfish, Strawberries, Tomatoes, Chocolate, Pollen, Cats ]

allergenToNum : Allergy -> Int
allergenToNum allergy =
    case allergy of
        Eggs -> 1
        Peanuts -> 2
        Shellfish -> 4
        Strawberries -> 8
        Tomatoes -> 16
        Chocolate -> 32
        Pollen -> 64
        Cats -> 128


isAllergicTo : Allergy -> Int -> Bool
isAllergicTo allergy score =
    Bitwise.and (allergenToNum allergy) score > 0


toList : Int -> List Allergy
toList score =
    List.filter (\allergen -> isAllergicTo allergen score) allergens
