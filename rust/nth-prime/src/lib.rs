pub fn nth(n: u32) -> u32 {

    let mut current_prime = 2; // first prime number
    let mut prime_pos = 0;

    while prime_pos < n {
        current_prime += 1;

        if is_prime(current_prime) {
            prime_pos += 1;
        }
    }

    return current_prime;
}

pub fn is_prime(n: u32) -> bool {

    if n < 2 {
        return false;
    }

    if n == 2 || n == 3 {
        return true;
    }

    if n % 2 == 0 {
        return false;
    }

    let number = n as f64;
    for i in (3..=(number.sqrt() as u32)).step_by(2) {
        if n % i == 0 {
            return false;
        }
    }

    return true
}
