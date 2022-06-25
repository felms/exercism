export const convert = (number, baseFrom, baseTo) => {
   if (baseFrom < 2) {
       throw new Error('Wrong input base');
   }

   if (baseTo < 2) {
       throw new Error('Wrong output base');
   }

   if (number.length === 0) {
       throw new Error('Input has wrong format');
   }

   let nBaseTen = 0;
   let exponent = 0;

   for (let i = number.length - 1; i >= 0; i--) {

       
       let sum = number.reduce((a, b) => a + b, 0);
       if ((sum > 0 && number[0] === 0) 
           || (sum === 0 && number.length > 1)
           || number[i] >= baseFrom || number[i] < 0) {
           throw new Error('Input has wrong format');
       }

       let digit = number[i] * Math.pow(baseFrom, exponent);
       nBaseTen += digit;
       exponent++;
   }

   if (nBaseTen === 0) {
       return [0];
   }
   
   let digits = [];
   while(nBaseTen > 0) {
       digits.push(nBaseTen % baseTo);
       nBaseTen = Math.trunc(nBaseTen / baseTo);
   }

   digits.reverse();

   return digits;
   
};
