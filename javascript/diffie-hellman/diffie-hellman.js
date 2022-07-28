export class DiffieHellman {
  constructor(p, g) {
    if (!this.isPrime(p) || !this.isPrime(g)) {
      throw new Error();
    }

    this.p = p;
    this.g = g;
  }

  getPublicKey(privateKey) {
    if (privateKey <= 1 || privateKey >= this.p) {
      throw new Error();
    }

    return (this.g ** privateKey) % this.p;
  }

  getSecret(theirPublicKey, myPrivateKey) {
    return  (theirPublicKey ** myPrivateKey) % this.p;
  }

  isPrime(n) {

    if (n < 2) {
      return false;
    }

    if (n === 2 || n === 3) {
      return true;
    }

    if (n % 2 === 0) {
      return false;
    }

    for (let i = 3; i * i <= n; i += 2) {
      if (n % i === 0) {
        return false;
      }
    }

    return true;
  }
}
