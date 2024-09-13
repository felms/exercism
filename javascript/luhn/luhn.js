export const valid = (input) => {

    let sin = input.replaceAll(/\s+/g, '');

    let sum = [...sin].toReversed()
            .map(Number)
            .reduce((acc, num, index) => 
                acc + (index % 2 === 0 ? num : 
                        num * 2 <= 9 ? num * 2 : (num * 2 - 9)), 0);

    return sin.length >= 2 && sum % 10 === 0;
};
