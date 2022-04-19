export class Matrix {
  rows = [];
  columns = [];
  constructor(matrix) {
    let lines = matrix.split('\n');
    
    
    for (let i = 0; i < lines.length; i++) {
      let row = [];
      let r = lines[i].split(/\s/);
      for (let j = 0; j < r.length; j++){
        row.push(parseInt(r[j]));
      }
      this.rows.push(row);
    }
    
    
    for (let j = 0; j < this.rows[0].length; j++){
      let column = [];
      for (let i = 0; i < this.rows.length; i++ ) {
        column.push(this.rows[i][j]);
      }
      this.columns.push(column);
    }
    
  }

  get rows() {
    return this.rows;
  }

  get columns() {
    return this.columns;
  }
}
