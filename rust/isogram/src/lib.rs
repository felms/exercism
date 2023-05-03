use std::collections::HashSet;

pub fn check(candidate: &str) -> bool {
    let mut s: HashSet<char> = HashSet::new();

    candidate
        .to_lowercase()
        .chars()
        .filter(|c| c.is_alphabetic())
        .all(|c| s.insert(c))
}
