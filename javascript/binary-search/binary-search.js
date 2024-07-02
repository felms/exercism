export const find = (array, value) => {

    let low = 0;
    let high = array.length;

    while (low <= high) {
        let middle = Math.floor((low + high) / 2);

        if (array[middle] === value) {
            return middle;
        }

        if (array[middle] < value) {
            low = middle + 1;
        } else {
            high = middle - 1;
        }
    }

    throw new Error('Value not in array');
};
