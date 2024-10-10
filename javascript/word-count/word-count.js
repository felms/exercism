export const countWords = (input) => {
    return input.toLowerCase().match(/\w+('\w+)?/g)
            .reduce((acc, word) => ({...acc, [word]: (acc[word] ?? 0) + 1}), {});
};
