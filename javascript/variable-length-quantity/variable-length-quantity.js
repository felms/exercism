export const encode = (numbers) => {

  let res = [];
  numbers.forEach(number => res.push(...encodeNumber(number)));

  return res;
};

export const decode = (numbers) => {

  let res = [];
  let sum = 0;
  let MASK = 127;

  numbers.forEach((number, index) => {

    // pego o 'most significant bit'
    let msb = number >>> 7;

    // pego os ultimos 7 bits
    let current = number & MASK;

    // adicionando current à soma
    sum = sum << 7;
    sum = sum | current;

    if (msb === 0) {
      sum = sum >>> 0; // falando para o JS que o número de 32 bits é positivo
                       // por que é desse jeito?
                       // não tenho a minima idéia!
      
      res.push(sum);
      sum = 0;
    } else if (msb === 1 && index === numbers.length - 1) {
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


  // para numeros maiores 
  // que 128 

  let MASK = 127;
  let res = [];
  let num = number;

  while (num > 0) {

    // pego os ultimos 7 bits
    let digits = num & MASK;

    if (res.length > 0) {
      // apos o primeiro byte eu insiro 
      // o 'most significant bit' para
      // indicar que teremos outros bytes depois.
      digits = digits | (MASK + 1);
    }

    res.unshift(digits);

    // elimino do numero os bits já utilizados
    num = num >>> 7;

  }
  
  return res;

};

