export class GoCounting {
  constructor(board) {
    this.board = [];
    board.forEach(row => this.board.push(row.split('')));

    this.rows = this.board.length;
    this.columns = this.board[0].length;
  }

  getTerritory(x, y) {

    if ((x < 0 || y < 0)
      || (x >= this.columns || y >= this.rows)) {
      return { error: 'Invalid coordinate' };
    }

    // Computes the territory

    let territory = [];
    let queue = [];
    queue.push([x, y]);

    while (queue.length > 0) {
      let p = queue.shift();
      let [px, py] = p;

      if (this.board[px][py] === ' ') {
        if (!this.containsItem(territory, p)) {
          territory.push(p);
          let neighbors = this.getNeighbors(p);
          neighbors.forEach(point => queue.push(point)); // TODO sub por push
        }
      }
    } 

    // Computes the owner

    let oTerritory = [...territory];
    let slots = [];
    let allNeighbors = [];

    for (let point of oTerritory) {
      allNeighbors.push(...this.getNeighbors(point));
    }
    oTerritory.push(...allNeighbors);

    for (let point of oTerritory) {
      let [px, py] = point;
      let slot = this.board[py][px]
      slots.push(slot);
    }

    let owner;

    if (slots.includes('B') && (slots.includes(' ')) && (!(slots.includes('W')))) {
      owner = 'BLACK';
    } else if (slots.includes('W') && (slots.includes(' ') && (!(slots.includes('B'))))) {
      owner = 'WHITE';
    } else if (slots.includes('W') && (slots.includes(' ') && (slots.includes('B')))) {
      owner = 'NONE';
    } else if ((slots.includes('W') && slots.includes('B'))) {
      owner = 'NONE';
    }

    owner = owner || 'NONE';

    territory = territory.sort((p0, p1) => { // Tem que ordenar pq o JEST é burro e não 
      let [x0, y0] = p0;                     // consegue reconhecer que dois arrays 
      let [x1, y1] = p1;                     // são iguais se a ordem deles for diferente

      return x0 !== x1 ? x0 - x1 : y0 - y1;
    });

    return {owner, territory};

  }

  getTerritories() {
    throw new Error('Remove this statement and implement this function');
  }

  getNeighbors(point) {

    let [x, y] = point;

    let neighbors = [];

    if (x > 0) {
      neighbors.push([x - 1, y]);
    }

    if (x < this.rows - 1) {
      neighbors.push([x + 1, y]);
    }

    if (y > 0) {
      neighbors.push([x, y - 1]);
    }

    if (y < this.columns - 1) {
      neighbors.push([x, y + 1]);
    }

    return neighbors;
  }

  containsItem(array, item) {
    return array.some(i => JSON.stringify(i) === JSON.stringify(item));
  }
}
