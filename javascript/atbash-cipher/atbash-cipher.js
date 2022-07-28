const PLAIN = 'abcdefghijklmnopqrstuvwxyz';
const CIPHER = 'zyxwvutsrqponmlkjihgfedcba';

export const encode = (plainText) => {

  plainText = plainText.toLowerCase().replaceAll(/\W/g, '');

  let encodedText = [];
  for (let i = 0; i < plainText.length; i++) {

    if (i > 0 && i % 5 === 0) {
      encodedText.push(' ');
    }

    encodedText.push(encodeLetter(plainText[i]));
  }

  return encodedText.join('');
};

export const decode = (cipherText) => {

  cipherText = cipherText.replaceAll(/\s+/g, '');

  return cipherText.split('').map(letter => decodeLetter(letter)).join('');

};

const encodeLetter = (letter) => {
  let index = PLAIN.indexOf(letter);

  if (index < 0) {
    return letter;
  }

  return CIPHER.charAt(index);
};

const decodeLetter = (letter) => {
  let index = CIPHER.indexOf(letter);

  if (index < 0) {
    return letter;
  }

  return PLAIN.charAt(index);
};
