export const find = (array, number) => {

	let low = 0;
	let high = array.length - 1;
	
	while (low <= high) {
		let m = Math.trunc((low + high) / 2);
		if (array[m] < number) {
			low = m + 1;
		} else if (array[m] > number) {
			high = m - 1;	
		} else {
			return m;
		}

	}

	throw new Error('Value not in array');
};
