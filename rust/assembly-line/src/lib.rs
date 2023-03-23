pub fn production_rate_per_hour(speed: u8) -> f64 {
    let cars_per_hour = 221.0;
    let s = speed as f64;

    match speed {
        1..=4 => s * cars_per_hour,
        5..=8 => s * cars_per_hour * 0.9,
        9 | 10 => s * cars_per_hour * 0.77,
        _ => s * cars_per_hour
    }
}

pub fn working_items_per_minute(speed: u8) -> u32 {
    production_rate_per_hour(speed) as u32 / 60
}
