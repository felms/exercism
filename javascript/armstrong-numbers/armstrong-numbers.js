export const isArmstrongNumber = (number) => {

	let digits = [];

	let n = number;
	let numberOfDigits = 0;

	while (n > 0) {
		digits.push(n % 10);
		n = Math.trunc(n / 10);
		numberOfDigits++;
	}
	
	let sum = digits.map(digit => Math.pow(digit, numberOfDigits))
						.reduce((a, b) => a + b, 0);

	return sum === number;
};
