export const prime = (nth) => {
	
	if (nth === 0) {
		throw new Error('there is no zeroth prime');
	}
	
	let primesList = [];

	let i = 2;
	while (primesList.length < nth) {
		if (isPrime(i)) {
			primesList.push(i);
		}
		i++;
	}

	return primesList.pop();
	
};

const isPrime = (number) => {
	
	if (number < 2) {
		return false;
	}

	if (number === 2) {
		return true;
	}
	
	if (number % 2 === 0) {
		return false;
	}

	for (let i = 3; i <= Math.sqrt(number); i += 2) {
		if (number % i === 0){
			return false;
		}
	}

	return true;
}
