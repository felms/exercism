export const compute = (strand0, strand1) => {
  if (strand0.length !== strand1.length) {
    throw new Error('strands must be of equal length');
  }

  let distance = 0;

  for (let i = 0; i < strand0.length; i++) {
    if (strand0[i] != strand1[i]) {
      distance++;
    }
  }

  return distance;

};
