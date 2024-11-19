export const encode = (inputString) => 
    inputString.replaceAll(/(.)\1+/g, 
        (match, str, ...rem) => `${match.length}${str}`);

export const decode = (inputString) => 
    inputString.replaceAll(/(\d+)([ a-z])/gi, 
        (_, length, str, ...rem) => str.repeat(length));

