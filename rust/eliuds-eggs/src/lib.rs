pub fn egg_count(display_value: u32) -> usize {
    let mut count: usize = 0;
    let mut num: usize = display_value as usize;

    while num > 0 {
        count += num & 1;
        num >>= 1;
    }

    return count;
}
