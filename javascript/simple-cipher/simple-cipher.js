export class Cipher {
  constructor(key) {
    this.alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
    this._key = key || this.generateKey();
  }

  encode(word) {
    let result = word.split("");
    let key = [];
    while (key.length < result.length) {
      key.push(this._key);
    }
    key = key.join("");

    for (let i = 0; i < result.length; i++) {
      let pos = this.alphabet.indexOf(result[i]) + this.alphabet.indexOf(key[i]);
      pos = pos % 26;
      result[i] = this.alphabet[pos];
    }
    return result.join("");
  }

  decode(word) {
    let result = word.split("");
    let key = [];
    while (key.length < result.length) {
      key.push(this._key);
    }
    key = key.join("");

    for (let i = 0; i < result.length; i++) {
      let pos = this.alphabet.indexOf(result[i]) - this.alphabet.indexOf(key[i]);
      pos = pos >= 0 ? pos : pos + 26;
      result[i] = this.alphabet[pos];
    }
    return result.join("");
  }

  get key() {
    return this._key;
  }

  generateKey() {
    let key = [];
    for (let i = 0; i < 100; i++) {
      let pos = Math.floor(Math.random() * 26);
      key.push(this.alphabet[pos]);
    }

    return key.join("");
  }
}