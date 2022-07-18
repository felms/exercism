export const keep = (input, predicate) => {

    let res = [];

    for (let item of input) {

        if (predicate(item)) {
            res.push(item);
        }
    }

    return res;
};

export const discard = (input, predicate) => {

    let res = [];

    for (let item of input) {

        if (!predicate(item)) {
            res.push(item);
        }
    }

    return res;

};
