export const proverb = (...words) => {

    if (words.length === 0) {
        return '';
    }

    let result = '';

    let want;
    let lost;
    let qObject = words[words.length - 1];
    let hasQualifier = false;
    if (typeof qObject === 'object' && qObject !== null) {
        words.pop();
        hasQualifier = true;
    }

    for (let i = 0; i < words.length - 1; i++) {
        want = words[i];
        lost = words[i + 1];
        result = result.concat(`For want of a ${want} the ${lost} was lost.\n`);
    }


    if (hasQualifier) {
        result = result.concat(`And all for the want of a ${qObject.qualifier} `
            + `${words[0]}.`);
    } else {
        result = result.concat('And all for the want of a ' + words[0] + '.');
    }

    return result;
};
