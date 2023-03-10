/// Determine whether a sentence is a pangram.
pub fn is_pangram(sentence: &str) -> bool {

    let s = sentence.to_lowercase();
    ('a'..='z').all(|letter| s.contains(letter))
}
