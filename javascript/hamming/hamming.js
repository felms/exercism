export const compute = (strand1, strand2) => {
    if (strand1.length !== strand2.length) {
        throw new Error('strands must be of equal length');
    }

    return [...strand1]
        .filter((n, index) => n !== strand2[index]).length;
};
