export const score = (x, y) => {
  let distance = distanceBetweenPoints(0, 0, x, y);
  return distance <= 1 ? 10 
    : distance <= 5 ? 5
    : distance <= 10 ? 1
    : 0;
};

const distanceBetweenPoints = (x1, y1, x2, y2) => {
  return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
};
