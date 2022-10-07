export const encode = (numbers) => {

  let res = [];
  numbers.forEach(number => res.push(...encodeNumber(number)));

  return res;
};

export const decode = (numbers) => {

  let res = [];
  let sum = [];
  numbers.forEach(number => {
    console.log(`number: ${number}`)
    let strRep = number.toString(2);
    console.log(`strRep: ${strRep}`);
    if (strRep.length === 8) {
      strRep = strRep.substring(1);
    }
    sum.push(strRep.padStart(7, '0'));
    console.log(`sum: ${sum}`);
  });

  res.push(parseInt(sum.join(''), 2));
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

const decodeNumber = (number) => {

  // não precisa fazer nada em numeros
  // de apenas um byte
  if (number < 128) {
    return number;
  }

  // para numeros > 1 byte
  
  // transforma o numero para uma string binaria,
  // retira o 'most significant bit',
  // converte para int de novo e retorna
  let strRep = number.toString(2).substring(1);

  return parseInt(strRep, 2);
};
