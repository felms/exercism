pub fn factors(n: u64) -> Vec<u64> {

    let mut factors:Vec<u64> = Vec::new();
    let mut number = n;
    let mut factor = 0;

    while number > 1 && factor <= number {
        if is_prime(factor) && number % factor == 0 {
            factors.push(factor);
            number /= factor;
        } else {
            factor += 1;
        }

    }

    factors
}

pub fn is_prime(n: u64) -> bool {
    
    if n < 2 {
        return false;
    }

    if n == 2 || n == 3 {
        return true;
    }

    let number = n as f64;
    for i in (3..=(number.sqrt() as u64)).step_by(2) {
        if n % i == 0 {
            return false;
        }
    }

    return true
}
