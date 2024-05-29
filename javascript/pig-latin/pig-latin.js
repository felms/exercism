const regex = /^[aeiou]|^xr|^y[^aeiou]/;

export const translate = (phrase) => 
    phrase.split(' ').map(translateWord).join(' ');

export const translateWord = (word) => {
    if (regex.test(word)){
        return word + 'ay';
    }

    let newWord = word.startsWith('qu') 
                    ? word.substring(2) + 'qu' : word.substring(1) + word[0];

    return translateWord(newWord);
};

