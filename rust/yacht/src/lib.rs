#[derive(Debug)]
pub enum Category {
    Ones,
    Twos,
    Threes,
    Fours,
    Fives,
    Sixes,
    FullHouse,
    FourOfAKind,
    LittleStraight,
    BigStraight,
    Choice,
    Yacht,
}

type Dice = [u8; 5];

pub fn score(dice: Dice, category: Category) -> u8 {
    use Category::*;
    let mut dice = dice;
    dice.sort();
    match category {
        Ones => freq_number(dice, 1),
        Twos => 2 * freq_number(dice, 2),
        Threes => 3 * freq_number(dice, 3),
        Fours => 4 * freq_number(dice, 4),
        Fives => 5 * freq_number(dice, 5),
        Sixes => 6 * freq_number(dice, 6),
        FullHouse => score_full_house(dice),
        FourOfAKind => score_four_of_a_kind(dice),
        LittleStraight => score_straight(dice, &[1, 2, 3, 4, 5]),
        BigStraight => score_straight(dice, &[2, 3, 4, 5, 6]),
        Choice => dice.iter().sum(),
        Yacht => if freq_number(dice, dice[0]) == 5 { 50 } else { 0 },
    }
}

fn score_full_house(dice: Dice) -> u8 {
    if dice.iter().any(|&value| freq_number(dice, value) == 2)
        && dice.iter().any(|&value| freq_number(dice, value) == 3)
    {
        dice.iter().sum()
    } else {
        0
    }
}

fn score_four_of_a_kind(dice: Dice) -> u8 {
    if freq_number(dice, dice[1]) >= 4 {
        4 * dice[1]
    } else {
        0
    }
}

fn score_straight(dice: Dice, straight: &[u8]) -> u8 {
    if dice == *straight {
        30
    } else {
        0
    }
}

fn freq_number(dice: Dice, number: u8) -> u8 {
    dice.iter().filter(|&n| *n == number).count() as u8
}
