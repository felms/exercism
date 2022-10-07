export const encode = (numbers) => {

  let res = [];
  numbers.forEach(number => res.push(...encodeNumber(number)));

  return res;
};

export const decode = (numbers) => {

  let res = [];
  let sum = [];
  numbers.forEach((number, index) => {

    // converte o número para a uma string
    // da representação em binário.
    // o padStart é para os casos em que o número
    // é menor que 1 byte
    let strRep = number.toString(2).padStart(8, '0');

    // cria uma nova string sem o 'most significant bit'
    // e adiciona à soma
    let n = strRep.substring(1);
    sum.push(n.padStart(7, '0'));

    // se o MSB é '0' soma-se os itens 
    // armazena o número
    // e zera o array
    if (strRep.charAt(0) === '0') {
      res.push(parseInt(sum.join(''), 2));
      sum = [];
    } else if (strRep.charAt(0) === '1' && index === numbers.length - 1) {
      // caso o MSB for '1' no último item de uma sequencia
      throw new Error('Incomplete sequence');
    }
  });

  return res;

};

const encodeNumber = (number) => {

  // não precisa fazer nada em numeros
  // de apenas um byte
  if (number < 128) {
    return [number];
  }

  // para numeros > 1 byte

  // transoforma o numero para 
  // uma string binario
  let strRep = number.toString(2);


  // separa em pedaços de 7 bits cada
  let chunks = [];

  while(strRep.length > 0) {
    let size = strRep.length;
    let currentChunk = strRep.substring(size - 7);
    currentChunk = currentChunk.padStart(7, '0');
    chunks.push(currentChunk);
    strRep = strRep.substring(0, size - 7);
  }
  chunks.reverse();

  // adiciona o 'most significant bit'
  // e monta a resposta
  let res = [];
  chunks.forEach((chunk, index) => {
    let n;
    if (index < chunks.length - 1) {
      n = '1' + chunk;
    } else {
      n = '0' + chunk;
    }

    res.push(parseInt(n, 2));
  });

  return res;
};

