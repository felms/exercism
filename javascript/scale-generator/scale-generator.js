export class Scale {
  constructor(tonic) {
    this._tonic = tonic;
    this._sharps = ['A', 'A#', 'B', 'C', 'C#', 'D', 'D#', 'E', 'F', 'F#','G', 'G#'];
    this._flats = ['A', 'Bb', 'B', 'C', 'Db', 'D', 'Eb', 'E', 'F', 'Gb', 'G', 'Ab']; 

  }

  chromatic() {
    switch(this._tonic) {
      case 'C':
      case 'a':
      case 'G':
      case 'D':
      case 'A':
      case 'E':
      case 'B':
      case 'F#':
      case 'e':
      case 'b':
      case 'f#':
      case 'c#':
      case 'g#':
      case 'd#':
        return this.fromSharps();
      case 'F':
      case 'Bb':
      case 'Eb':
      case 'Ab':
      case 'Db':
      case 'Gb':
      case 'd':
      case 'g':
      case 'c':
      case 'f':
      case 'bb':
      case 'bb':
        return this.fromFlats();
        break;
    }
  }

  interval(intervals) {
    let arr = this.chromatic();
    let intervalsList = intervals.split('');

    let ans = [];

    ans.push(arr.shift());

    while (intervalsList.length > 0 && arr.length > 0) {
      let next = intervalsList.shift();
      if (next === 'm') {
        let a = arr.shift();
        if (a) {
          ans.push(a);
        }
      } else if (next === 'M') {
        arr.shift();
        let a = arr.shift();
        if (a) {
          ans.push(a);
        }
      } else if (next === 'A') {
        arr.shift();
        arr.shift();
        let a = arr.shift();
        if (a) {
          ans.push(a);
        }
      }

    }

    return ans;

  }

  fromSharps() {
    let ans = [];

    let index = this._sharps.indexOf(this._tonic);

    if (index < 0) {
      this._tonic = this._tonic[0].toUpperCase() + this._tonic.substring(1);
      index = this._sharps.indexOf(this._tonic);
    }

    ans.push(this._tonic);
    let postArr = this._sharps.slice(index + 1);
    let preArr = this._sharps.slice(0, index);
    ans = [...ans, ...postArr, ...preArr];
    return ans;
  }

  fromFlats() {
    let ans = [];

    let index = this._flats.indexOf(this._tonic);

    if (index < 0) {
      this._tonic = this._tonic[0].toUpperCase() + this._tonic.substring(1);
      index = this._flats.indexOf(this._tonic);
    }

    ans.push(this._tonic);
    let postArr = this._flats.slice(index + 1);
    let preArr = this._flats.slice(0, index);
    ans = [...ans, ...postArr, ...preArr];
    console.log(ans);
    return ans;
  }

}
