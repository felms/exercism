export const parse = (phrase) => {
    return phrase.toUpperCase().replaceAll(/-|_/g, ' ')
                    .split(/\s+/).map(word => word[0]).join('');
};
