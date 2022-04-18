//
// This is only a SKELETON file for the 'Gigasecond' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const gigasecond = (inputDate) => {
  const milis = 1_000_000_000_000 + inputDate.getTime();
  const newDate = new Date();
  newDate.setTime(milis);
  return newDate;
};
