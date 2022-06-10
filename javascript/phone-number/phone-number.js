export const clean = (number) => {
  let regex = /[\s+\.\(\)\-]/g;

  let n = number.replace(regex, "");

  if (n.length < 10) {
    throw new Error('Incorrect number of digits');
  }

  if (n.length === 11) {
    if (n.charAt(0) !== '1') {
      throw new Error('11 digits must start with 1');
    }

    n = n.substr(1);
  }

  if (n.length > 11) {
    throw new Error('More than 11 digits');
  }

  regex = /[a-zA-Z]/;
  if (regex.test(n)) {
    throw new Error('Letters not permitted');
  }

  regex = /[^a-zA-Z0-9]/;
  if (regex.test(n)) {
    throw new Error('Punctuations not permitted');
  }

  if (n.charAt(0) === '0') {
    throw new Error('Area code cannot start with zero');
  }

  if (n.charAt(0) === '1') {
    throw new Error('Area code cannot start with one');
  }

  if (n.charAt(3) === '0') {
    throw new Error('Exchange code cannot start with zero');
  }

  if (n.charAt(3) === '1') {
    throw new Error('Exchange code cannot start with one');
  }

  return n;

};
