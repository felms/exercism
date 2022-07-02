export const square = (squareNumber) => {
    
    if (squareNumber < 1 || squareNumber > 64) {
        throw new Error('square must be between 1 and 64');
    }
    
    return 2n ** BigInt(squareNumber - 1);
};

export const total = () => {
    
    let a1 = square(1);
    let q = 2n;
    let n = 64n;
    
    return a1 * (q ** n - 1n) ;
};
