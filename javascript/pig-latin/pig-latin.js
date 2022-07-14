export const translate = (input) => {

    let string = '';

    let words = input.split(/\s+/g);

    for (let i = 0; i < words.length; i++) {
        let word = words[i];
        if (/^(xr|yt).*|^[aeiou].*/.test(word)) {
            string = string.concat(rule1(word));
        } else if (/[^aeiou]*qu.*/.test(word)) {
            string = string.concat(rule3(word));
        } else if ((word.length == 2 && word.charAt(1) == 'y') 
            || /^[^aeiou]+y.*/.test(word)) {
            string = string.concat(rule4(word));
        } else if (/^([^aeiou]+).*/.test(word)) {
            string = string.concat(rule2(word));
        }

        string = string.concat(' ');
    }

    return string.trim();
};

const rule1 = (input) => {
    return input + 'ay';
}

const rule2 = (input) => {
    let consonants = input.split(/[aeiou]/)[0];
    let endOfWord = input.substring(consonants.length);

    return endOfWord + consonants + 'ay';
}

const rule3 = (input) => {
    let tokens = input.split(/.*qu/);
    let endOfWord = tokens[tokens.length - 1];
    let consonants = input.replace(endOfWord, '');

    return endOfWord + consonants + 'ay';
}

const rule4 = (input) => {
    let tokens = input.split('y');
    let consonants = tokens[0];
    let endOfWord = input.replace(consonants, '');

    return endOfWord + consonants + 'ay';

}
