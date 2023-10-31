pub fn is_armstrong_number(num: u32) -> bool {
    
    let digits: u32 = (num as f32).log10() as u32 + 1;
    let mut number: u64 = num as u64;
    let mut sum = 0;

    while number > 0 {
        let digit = number % 10;
        sum += digit.pow(digits);
        number /= 10;
    }

    (num as u64) == sum

}
