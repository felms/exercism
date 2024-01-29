export const eggCount = (displayValue) => {
    let count  = 0;

    while(displayValue) {
        count += (displayValue & 1);
        displayValue = displayValue >> 1;
    }

    return count;
};
