export const score = (x, y) => {
    let d = Math.sqrt((x ** 2) + (y ** 2));

    if (d <= 1) {
        return 10;
    }

    if (d <= 5) {
        return 5;
    }

    if (d <= 10) {
        return 1;
    }

    return 0;
};
