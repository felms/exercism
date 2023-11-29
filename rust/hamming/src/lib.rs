/// Return the Hamming distance between the strings,
/// or None if the lengths are mismatched.
pub fn hamming_distance(s1: &str, s2: &str) -> Option<usize> {
    match s1.len() == s2.len() {
        false => None,
        true => s1.chars().zip(s2.chars()) 
            .map(|(a, b)| if a == b { 0 } else { 1 }) 
            .sum::<usize>()
            .into(),
    }
}
