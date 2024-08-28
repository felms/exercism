export const eggCount = (displayValue) => {
    let count = 0;

    let n = displayValue;
    while (n > 0) {
        count += n & 1;
        n = n >> 1;
    }

    return count;
};
