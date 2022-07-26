const M = 26;
const ALPHABET = 'abcdefghijklmnopqrstuvwxyz';

export const encode = (phrase, key) => {

  let {a, b} = key;

  // Testa se os números são coprimos
  let gcdAB = gcd(a, M);
  if (gcdAB != 1) {
    throw new Error('a and m must be coprime.');
  }

  let letters = phrase.toLowerCase()
    .replaceAll(/[\W]/g, '').split('');
  
  let encodedText = letters.map(letter => encodeChar(letter, key)).join('');

  let sb = '';
  let count = 1;
  for (let c of encodedText) {
    sb = sb.concat(c);
    if (count % 5 == 0) {
      sb = sb.concat(' ');
    }
    count++;
  }

  return sb.trim();
};

export const decode = (phrase, key) => {

  let {a, b} = key;

  // Testa se os números são coprimos
  let gcdAB = gcd(a, M);
  if (gcdAB != 1) {
    throw new Error('a and m must be coprime.');
  }

  let letters = phrase.toLowerCase()
    .replaceAll(/[\W]/g, '').split('');

  return letters.map(letter => decodeChar(letter, key)).join('');

};

const encodeChar = (char, key) => {

  let {a, b} = key;

  let x = ALPHABET.indexOf(char);

  // Caso não seja uma letra
  if (x < 0) {
    return char;
  }

  // Função de criptografia
  let eX = (a * x + b) % M;

  return ALPHABET.charAt(eX);
};

const decodeChar = (char, key) => {

  let {a, b} = key;

  let y = ALPHABET.indexOf(char);

  // Caso não seja uma letra
  if (y < 0) {
    return char;
  }

  // Encontra o multiplicativo modular inverso
  let a1 = mmi(a);

  // Aplica a função de descriptografia
  let dY = (a1 * (y - b)) % M;

  // Ajusta o range para o caso de valores fora do limite (0 - 25)
  dY = dY < 0 ? dY + M : dY;

  return ALPHABET.charAt(dY);

};

// Acha o máximo divisor comum
const gcd = (a, b) => {
  if (b == 0) {
    return a;
  }

  return gcd(b, a % b);
};

// Acha o multiplicativo modular inverso
const mmi = (a) => {

  let b = 0;

  for (let i = 0; i < M; i++) {
    let r = (a * i) % M;
    if (r == 1) {
      b = i;
    }
  }

  return b;
};
