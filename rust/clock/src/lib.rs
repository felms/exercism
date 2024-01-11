use std::fmt;

const MINUTES_PER_DAY: i32 = 1440;
const MINUTES_PER_HOUR: i32 = 60;

#[derive(Debug, PartialEq)]
pub struct Clock {
    minutes: i32,
}

impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        let total_minutes = (hours * MINUTES_PER_HOUR + minutes).rem_euclid(MINUTES_PER_DAY);

        Clock {
            minutes: total_minutes,
        }
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        let m = (self.minutes % 60) + minutes;

        Clock::new(self.minutes / 60, m)
    }
}

impl fmt::Display for Clock {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "{:02}:{:02}", self.minutes / 60, self.minutes % 60)
    }
}
