/// Check a Luhn checksum.
pub fn is_valid(code: &str) -> bool {

    if code.chars().filter(|c| c.is_ascii_digit()).count() < 2 
        || code.chars().any(|c| !c.is_ascii_digit() && c != ' ') {
        return false;
    }

    code.chars().rev()
        .filter(|c| c.is_ascii_digit())
        .map(|c| c.to_digit(10).unwrap())
        .enumerate()
        .map(|(i, digit)| if i % 2 != 0 { digit * 2 } else { digit })
        .map(|digit| if digit > 9 { digit - 9 } else { digit })
        .sum::<u32>() % 10 == 0

}
