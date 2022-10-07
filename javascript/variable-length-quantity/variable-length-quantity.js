export const encode = (numbers) => {

  let res = [];

  numbers.forEach(number => res.push(...encodeNumber(number)));

  return res;
};

export const decode = () => {
  throw new Error('Remove this statement and implement this function');
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
    console.log(`strRep ${strRep}`);
  }
  chunks.reverse();
  console.log(`chunks: ${chunks}`);

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

  console.log(res);
  return res;
};
