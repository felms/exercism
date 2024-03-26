export const findAnagrams = (word, candidates) => 
    candidates
        .filter(candidate => candidate.toLowerCase() !== word.toLowerCase())
        .filter(candidate => isAnagram(word.toLowerCase(), candidate.toLowerCase()));

const isAnagram = (word, candidate) => 
    [...word].toSorted().join('') === [...candidate].toSorted().join('');

