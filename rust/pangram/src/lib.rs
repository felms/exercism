/// Determine whether a sentence is a pangram.
pub fn is_pangram(sentence: &str) -> bool {
    let alphabet = vec!["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"];

    let s = sentence.to_lowercase();

    alphabet.iter()
        .filter(|&letter| s.contains(letter))
        .collect::<Vec<_>>()
        .len() == 26
    
}
