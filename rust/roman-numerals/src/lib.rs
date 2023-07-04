use std::fmt::{Display, Formatter, Result};

pub struct Roman {
    thousands: u32,
    hundreds: u32,
    tens: u32,
    units: u32,
}

impl Display for Roman {
    fn fmt(&self, f: &mut Formatter<'_>) -> Result {

        let tt: &str = match self.thousands {
            1 => "M",
            2 => "MM",
            3 => "MMM",
            _ => "",
        };

        let h: &str = match self.hundreds {
            1 => "C",
            2 => "CC",
            3 => "CCC",
            4 => "CD",
            5 => "D",
            6 => "DC",
            7 => "DCC",
            8 => "DCCC",
            9 => "CM",
            _ => "",
        };

        let t: &str = match self.tens {
            1 => "X",
            2 => "XX",
            3 => "XXX",
            4 => "XL",
            5 => "L",
            6 => "LX",
            7 => "LXX",
            8 => "LXXX",
            9 => "XC",
            _ => "",
        };

        let u: &str = match self.units {
            1 => "I",
            2 => "II",
            3 => "III",
            4 => "IV",
            5 => "V",
            6 => "VI",
            7 => "VII",
            8 => "VIII",
            9 => "IX",
            _ => "",
        };

        write!(f, "{}{}{}{}", tt, h, t, u)
    }
}

impl From<u32> for Roman {
    fn from(num: u32) -> Self {

        let mut number = num;

        let u: u32 = number % 10;
        number /= 10;

        let t: u32 = number % 10;
        number /= 10;

        let h: u32 = number % 10;
        number /= 10;

        let tt: u32 = number % 10;


        Roman {
            thousands: tt,
            hundreds: h,
            tens: t,
            units: u,
        }
    }
}
