export const commands = (number) => {
  let list = [];
  let n = number;
  n = decToBin(n);

  if(n % 10 != 0) {
      list.push("wink");
      n -= 1;
  }

  if (n % 100 != 0) {
      list.push(("double blink"));
      n -= 10;
  }

  if (n % 1000 != 0) {
      list.push("close your eyes");
      n -= 100;
  }

  if (n % 10000 != 0) {
      list.push("jump");
      n -= 1000;
  }

  if (n % 100000 != 0) {
      list = list.reverse();
  }

  return list;

};

const decToBin = (number) => {
  let n = number;
  let result = 0;
  let count = 0;
  while(n > 0) {
      let r = n % 2;
      n -= r;
      n /= 2;
      result = (Math.pow(10, count) * r) + result;
      count++;
  }

  return result;
}