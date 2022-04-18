//
// This is only a SKELETON file for the 'RNA Transcription' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const toRna = (dnaString) => {
  let rnaString = "";
  
  const replaceFunction = nucleotide => {
      
      switch(nucleotide) {        
       case 'C':
         return 'G';
         break;
       case 'G':
         return 'C';
         break;
       case 'T':
         return 'A';
         break;
       case 'A':
         return 'U';
         break;

      }
  };

  for (let i = 0; i < dnaString.length; i++) {
    rnaString += replaceFunction(dnaString.charAt(i));
  }

  return rnaString;
};
