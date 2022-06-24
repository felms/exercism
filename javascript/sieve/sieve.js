export const primes = (limit) => {
	
	let sieve = [];		// Array de primos
	sieve.push(false);	// Não existem primos
	sieve.push(false);	// menores que '2'
	
	for (let i = 2; i <= limit; i++) {
		sieve.push(true);
	}
	
	for (let i = 0; i <= limit; i++) {
		if (sieve[i]) {
			for (let j = 2; j * i <= limit; j++) {
				sieve[j * i] = false;
			}
		}
	}
	
	let primesUpToLimit = [];
	for (let i = 0; i <= limit; i++) {
		if (sieve[i]) {
			primesUpToLimit.push(i);
		}
	}	

	return primesUpToLimit;
};
