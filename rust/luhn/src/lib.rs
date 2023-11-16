/// Check a Luhn checksum.
pub fn is_valid(code: &str) -> bool {
    let cleaned_code = code.replace(' ', "");

    if cleaned_code.len() < 2 || !cleaned_code.chars().all(|c| c.is_ascii_digit()) {
        return false;
    }

    let mut numbers: Vec<u32> = cleaned_code
        .chars()
        .map(|c| c.to_digit(10).unwrap())
        .collect();

    let len = numbers.len();

    for i in (0..(len - 1)).rev().step_by(2) {
        let digit = numbers[i] * 2;
        numbers[i] = if digit > 9 { digit - 9 } else { digit };
    }

    let sum: u32 = numbers.iter().sum();

    sum % 10 == 0
}
