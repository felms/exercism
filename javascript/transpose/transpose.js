export const transpose = (input) => {
    if (input.length === 0) {
        return input;
    }

    let maxLength = (arr, from) => Math.max(...arr.slice(from).map(i => i.length));

    let strings = input.map((str, index) => str.padEnd(maxLength(input, index)));

    return [...Array(maxLength(input, 0)).keys()]
        .map(i => strings.map(str => (str[i] ?? '')).join(''));
};
