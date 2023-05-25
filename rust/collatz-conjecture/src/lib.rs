pub fn collatz(n: u64) -> Option<u64> {

    do_collatz(n, 0)
}

pub fn do_collatz(n: u64, steps: u64) -> Option<u64> {

    match n {
        0 => None,
        1 => Some(steps),
        n if n % 2 == 0 => do_collatz(n / 2, steps + 1),
        _ => do_collatz(u64::checked_mul(n, 3)?.checked_add(1)?, steps + 1)
    }
}
