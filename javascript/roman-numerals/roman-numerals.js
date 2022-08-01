export const toRoman = (number) => {
  let units = ['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII', 'VIII', 'IX'];
  let tens = ['','X', 'XX', 'XXX', 'XL', 'L', 'LX', 'LXX', 'LXXX', 'XC'];
  let hundreds = ['', 'C', 'CC', 'CCC', 'CD', 'D', 'DC', 'DCC', 'DCCC', 'CM'];
  let thousands = ['', 'M', 'MM', 'MMM'];

  let romanNumber = '';

  let m = Math.trunc(number / 1000);
  romanNumber = thousands[m];

  let c = Math.trunc((number % 1000) / 100);
  romanNumber += hundreds[c];

  let x = Math.trunc((number % 100) / 10);
  romanNumber += tens[x];

  let i = number % 10;
  romanNumber += units[i];

  return romanNumber;
};
