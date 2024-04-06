import std/bitops, std/math, std/sequtils, std/setutils

type
  Allergen* = enum
    Eggs, Peanuts, Shellfish, Strawberries, Tomatoes, Chocolate, Pollen, Cats

proc isAllergicTo*(score: int, allergen: Allergen): bool =
  let code = pow(2.0, float(allergen.ord))
  bitand(score, int(code)) > 0

proc allergies*(score: int): set[Allergen] =
    Allergen.toSeq
            .filter(proc(allergen: Allergen): bool = isAllergicTo(score, allergen))
            .toSet
