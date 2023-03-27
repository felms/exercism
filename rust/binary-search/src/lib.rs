pub fn find(array: &[i32], key: i32) -> Option<usize> {
    let mut low: i8 = 0;
    let mut high: i8 = array.len() as i8 - 1;

    while low <= high {
        let mid = ((high - low) / 2) + low;
        let mid_index = mid as usize;
        let val = array[mid_index];

        if val == key {
            return Some(mid_index);
        }

        // Search values that are greater than val - to right of current mid_index
        if val < key {
            low = mid + 1;
        }

        // Search values that are less than val - to the left of current mid_index
        if val > key {
            high = mid - 1;
        }
    }
    None
}
