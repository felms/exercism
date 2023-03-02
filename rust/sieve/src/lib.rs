pub fn primes_up_to(upper_bound: u64) -> Vec<u64> {
    let len = upper_bound as usize;
    let mut sieve = vec![true; len + 1];
    sieve[0] = false;
    sieve[1] = false;

    for i in 2..=upper_bound as usize{
        if sieve[i] {
            let mut j = 2 * i;
            while j <= len {
                sieve[j] = false;
                j += i;
            }
            
        }
    }

    let mut result: Vec<u64> = Vec::new();
    for i in 0..=upper_bound as usize{
        if sieve[i] {
            result.push(i as u64);
        }
    }

    return result;
}
