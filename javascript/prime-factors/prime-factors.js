
export const primeFactors = (number) => {
  let primeFactors = [];

  let n = number;
  let factor = 0;

  while (n > 1 && factor <= n) {
    if (isPrime(factor) && n % factor === 0) {
      primeFactors.push(factor);
      n /= factor;
    } else {
      factor++;
    }
  }

  return primeFactors;

};

const isPrime = (n) => {

  if (n < 2) {
    return false;
  }

  if (n === 2) {
    return true;
  }

  if (n % 2 === 0) {
    return false;
  }

  for (let i = 3; i <= Math.sqrt(n); i += 2) {
    if (n % i === 0) {
      return false;
    }
  }

  return true;
}