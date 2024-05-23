import std/[math, random, sequtils]

type
  Character* = object
    strength*: int
    dexterity*: int
    constitution*: int
    intelligence*: int
    wisdom*: int
    charisma*: int
    hitpoints*: int

proc ability*: int =
  randomize()
  var rolls = newSeqWith(4, rand(1..6))
  sum(rolls) - min(rolls)
   
proc modifier*(n: int): int =
  floorDiv(n - 10, 2)

proc initCharacter*: Character =
  var ctt = ability()
  Character(
    strength: ability(),
    dexterity: ability(),
    constitution: ctt,
    intelligence: ability(),
    wisdom: ability(),
    charisma: ability(),
    hitpoints: 10 + modifier(ctt)
  )
