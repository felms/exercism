export const flatten = (inputArray, acc = []) => {
    if (inputArray.length === 0) {
        return acc;
    }

    let [head, ...tail] = inputArray;

    if(head == null) {
        return flatten(tail, acc);
    }

    if(Array.isArray(head)) {
        return flatten([...head, ...tail], acc);
    }

    return flatten(tail, [...acc, head]);
};
