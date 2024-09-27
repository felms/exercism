export const sum = (baseValues, limit) => {
    return [...Array(limit).keys()]
                .filter(n => baseValues.some(value => n % value == 0))
                .reduce((a, b) => a + b, 0);
};
