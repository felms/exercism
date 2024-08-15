use std::cmp;

#[derive(Debug)]

pub struct Item {
    pub weight: u32,
    pub value: u32,
}

pub fn maximum_value(max_weight: u32, items: &[Item]) -> u32 {
    max_val(max_weight, items, 0, 0)
}

pub fn max_val(max_weight: u32, items: &[Item], pos: usize, value: u32) -> u32 {
    if max_weight == 0 || pos == items.len() {
        return value;
    }

    if items[pos].weight <= max_weight {
        cmp::max(
            max_val(max_weight - items[pos].weight, items, pos + 1, value + items[pos].value),
            max_val(max_weight, items, pos + 1, value)
        )
    } else {
        max_val(max_weight, items, pos + 1, value)
    }
}
