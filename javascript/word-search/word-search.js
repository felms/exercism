class WordSearch {
  constructor(grid) {
    this.rows = grid;
    this.columns = this.#getColumns();
  }

  find(words) {

    let pos = {};
    words.forEach(word => pos[word] = this.#searchWord(word));

    return pos;
  }

  #searchWord(word) {

    let pos = this.#searchRows(word);
    if (pos) {
      return pos;
    }

    pos = this.#searchColumns(word);
    if (pos) {
      return pos;
    }

    pos = this.#searchLeftDiagonal(word);
    if (pos) {
      return pos;
    }

    pos = this.#searchRightDiagonal(word);
    if (pos) {
      return pos;
    }

    return undefined;
  }

  #searchRows(word) {

    // search left to right
    for (let i = 0; i < this.rows.length; i++) {
      let row = this.rows[i];
      let s = row.indexOf(word);
      if (s >= 0) {
        s++;
        let e = s + String(word).length;
        return {
          start : [i + 1, s],
          end : [i + 1, e - 1],
        };

      }

      // search right to left
      let reversedWord = word.split('').reverse().join('');
      s = row.indexOf(reversedWord);
      if (s >= 0) {
        s++;
        let e = s + String(reversedWord).length;
        return {
          start : [i + 1, e - 1],
          end : [i + 1, s],
        };

      }

    }

    return undefined;
  }

  #searchColumns(word) {

    for (let i = 0; i < this.columns.length; i++) {
      // search top to bottom
      let column = this.columns[i];
      let s = column.indexOf(word);
      if (s >= 0) {
        let e = s + String(word).length;
        return {
          start: [s + 1, i + 1],
          end: [i + 1, e]
        };
      }

      // search botton to top
      let reversedWord = word.split('').reverse().join('');
      s = column.indexOf(reversedWord);
      if (s >= 0) {
        let e = s + String(word).length;
        return {
          start: [e, i + 1],
          end : [s + 1, i + 1],
        };
      }

    }

    return undefined;
  }

  #searchLeftDiagonal(word) {

    // search top to bottom
    for (let i = 0; i < this.rows.length; i++) {

      let row = this.rows[i].split('');
      let wordAsList = word.split('');
      let currentLetter = wordAsList.shift();
      if (row.includes(currentLetter)) {

        let pos = row.indexOf(currentLetter);
        let s = [i + 1, pos + 1];
        let e = [i + 1, pos + 1];
        let wordIter = i;
        while (wordAsList.length > 0
          && wordIter + wordAsList.length < this.rows.length
          && pos + 1 < this.rows.length) {
          let currentRow = this.rows[wordIter + 1].split('');
          currentLetter = wordAsList.shift();
          if (currentLetter === currentRow[pos + 1]) {
            e = [wordIter + 2, pos + 2];
          } else {
            break;
          }
          wordIter++;
          pos++;
        }

        if (wordAsList.length === 0) {
          return {
            start: s, 
            end: e,
          };
        }

      }

    }

    // search bottom to top
    for (let i = 0; i < this.rows.length; i++) {

      let reversedWord = word.split('').reverse().join('');
      let row = this.rows[i].split('');
      let wordAsList = reversedWord.split('');
      let currentLetter = wordAsList.shift();
      if (row.includes(currentLetter)) {

        let pos = row.indexOf(currentLetter);
        let s = [i + 1, pos + 1];
        let e = [i + 1, pos + 1];
        let wordIter = i;
        while (wordAsList.length > 0
          && wordIter + wordAsList.length < this.rows.length
          && pos + 1 < this.rows.length) {
          let currentRow = this.rows[wordIter + 1].split('');
          currentLetter = wordAsList.shift();
          if (currentLetter === currentRow[pos + 1]) {
            e = [wordIter + 2, pos + 2];
          } else {
            break;
          }
          wordIter++;
          pos++;
        }

        if (wordAsList.length === 0) {
          return {
            start: e,
            end: s,
          };
        }

      }

    }

    return undefined;

  }

  #searchRightDiagonal(word) {

    // search bottom to top
    for (let i = 0; i < this.rows.length; i++) {

      let row = this.rows[i].split('');
      let reversedWord = word.split('').reverse().join('');
      let wordAsList = reversedWord.split('');
      let currentLetter = wordAsList.shift();
      if (row.includes(currentLetter)) {

        let pos = row.indexOf(currentLetter);
        let s = [pos + 1, i + 1];
        let e = [pos + 1, i + 1];
        let wordIter = i;
        while (wordAsList.length > 0
          && wordIter + wordAsList.length < this.rows.length
          && pos - 1 > 0) {
          let currentRow = this.rows[wordIter + 1].split('');
          currentLetter = wordAsList.shift();
          if (currentLetter === currentRow[pos - 1]) {
            e = [pos, wordIter + 2];
          } else {
            break;
          }
          wordIter++;
          pos--;
        }

        if (wordAsList.length === 0) {
          return {
            start: s,
              end: e,
            };
        }

      }

    }

    // search top to bottom
    for (let i = 0; i < this.rows.length; i++) {

      let row = this.rows[i].split('');
      let wordAsList = word.split('');
      let currentLetter = wordAsList.shift();
      if (row.includes(currentLetter)) {

        let pos = row.indexOf(currentLetter);
        let s = [i + 1, pos + 1];
        let e = [i + 1, pos + 1];
        let wordIter = i;
        while (wordAsList.length > 0
          && wordIter + wordAsList.length < this.rows.length
          && pos - 1 > 0) {
          let currentRow = this.rows[wordIter + 1].split('');
          currentLetter = wordAsList.shift();
          if (currentLetter === currentRow[pos - 1]) {
            e = [wordIter + 2, pos];
          } else {
            break;
          }
          wordIter++;
          pos--;
        }

        if (wordAsList.length === 0) {
          return {
            start: s,
            end: e,
          };
        }

      }
    }

    return undefined;
  }

  // creates a list with all columns
  #getColumns() {
    let cols = [];
    for (let j = 0; j < this.rows.length; j++) {
      let sb = '';
      for (let row of this.rows) {
        sb = sb.concat(row[j]);
      }
      cols.push(sb);
    }

    return cols;
  }
}

export default WordSearch;
