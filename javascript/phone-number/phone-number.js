export const clean = (phoneNumber) => {

    if (/[a-z]/g.test(phoneNumber)) {
        throw new Error('Letters not permitted');
    }

    if (/[^-+()\d\s.]/.test(phoneNumber)) {
        throw new Error('Punctuations not permitted');
    }

    let num = phoneNumber.replaceAll(/\D/g,'');

    if (num.length < 10) {
        throw new Error('Incorrect number of digits');
    }

    if (num.length > 11) {
        throw new Error('More than 11 digits');
    }

    if (/[^1].{10}/.test(num)) {
        throw new Error('11 digits must start with 1');
    }

    if (/^1?[01]\d{9}$/.test(num)) {
        let n = /^1?0\d{9}$/.test(num) ? 'zero' : 'one';
        throw new Error(`Area code cannot start with ${n}`);
    }

    if (/^\d{3,4}[01]\d{6}$/.test(num)) {
        let n = /^\d{3,4}0\d{6}$/.test(num) ? 'zero' : 'one';
        throw new Error(`Exchange code cannot start with ${n}`);
    }

    return num.length === 11 ? num.substring(1) : num;
};
