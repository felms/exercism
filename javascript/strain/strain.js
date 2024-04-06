export const keep = ([head, ...tail], predicate, res = []) => {
    if (!head) {
        return res;
    }

    return predicate(head) 
            ? keep(tail, predicate, [...res, head])
            : keep(tail, predicate, res);
};

export const discard = (arr, predicate) => keep(arr, item => !predicate(item)); 
