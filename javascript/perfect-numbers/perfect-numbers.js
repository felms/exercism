//
// This is only a SKELETON file for the 'Perfect Numbers' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const classify = (number) => {
  if (number < 1) {
    throw new Error('Classification is only possible for natural numbers.');
  }

  let alicotSum  = 0;
  for (let i = 1; i <= number / 2; i++) {
    if (number % i == 0) {
      alicotSum += i;
    }
  }

  return alicotSum == number ? 'perfect'
                             : alicotSum < number ? 'deficient' 
                             : 'abundant';

};
