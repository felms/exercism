export const isValid = (isbnCode) => {
	let code = isbnCode.replaceAll('-', '');
	
	if (!(/\d{9}(\d|X)/.test(code))) {
		return false;
	}
	
	if (code.length != 10) {
		return false;
	}
	
	let digits = code.split('').map(c => c === 'X' ? 10 : parseInt(c));
	let sum = 0;
	
	for (let i = 0; i < 10; i++) {
		sum += digits[i] * (10 - i);
	}
	
	return sum % 11 === 0;
	
};

