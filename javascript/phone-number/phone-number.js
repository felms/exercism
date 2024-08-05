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

    if (/[01]?[01][0-9]{9}/.test(num)) {
        let n = (num.length === 11 && num[1] === '0') 
                    || (num.length === 10 && num[0] === '0') ? 'zero' : 'one';
        throw new Error(`Area code cannot start with ${n}`);
    }

    return num.length === 11 ? num.substring(1) : num;
};
