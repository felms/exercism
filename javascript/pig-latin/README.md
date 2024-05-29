# Pig Latin

Welcome to Pig Latin on Exercism's JavaScript Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Introduction

Your parents have challenged you and your sibling to a game of two-on-two basketball.
Confident they'll win, they let you score the first couple of points, but then start taking over the game.
Needing a little boost, you start speaking in [Pig Latin][pig-latin], which is a made-up children's language that's difficult for non-children to understand.
This will give you the edge to prevail over your parents!

[pig-latin]: https://en.wikipedia.org/wiki/Pig_latin

## Instructions

Your task is to translate text from English to Pig Latin using the following rules:

- **Rule 1**: If a word begins with a vowel sound, add an "ay" sound to the end of the word (e.g. "apple" -> "appleay").
  Please note that "xr" and "yt" at the beginning of a word make vowel sounds (e.g. "xray" -> "xrayay", "yttria" -> "yttriaay").
- **Rule 2**: If a word begins with a consonant sound, move it to the end of the word and then add an "ay" sound to the end of the word (e.g. "pig" -> "igpay").
  Consonant sounds can be made up of multiple consonants, such as the "ch" in "chair" or "st" in "stand" (e.g. "chair" -> "airchay").
- **Rule 3**: If a word starts with a consonant sound followed by "qu", move them to the end of the word, and then add an "ay" sound to the end of the word (e.g. "square" -> "aresquay").
- **Rule 4**: If a word contains a "y" after a consonant cluster or as the second letter in a two letter word it makes a vowel sound (e.g. "rhythm" -> "ythmrhay", "my" -> "ymay").

## Source

### Created by

- @rchavarria

### Contributed to by

- @ankorGH
- @konni2020
- @matthewmorgan
- @ntshcalleia
- @ryanplusplus
- @SleeplessByte
- @tejasbubane

### Based on

The Pig Latin exercise at Test First Teaching by Ultrasaurus - https://github.com/ultrasaurus/test-first-teaching/blob/master/learn_ruby/pig_latin/