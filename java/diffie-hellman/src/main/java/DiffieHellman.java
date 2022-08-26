import java.math.BigInteger;
import java.util.Random;

public class DiffieHellman {

    public BigInteger privateKey(BigInteger prime) {

        return new BigInteger(prime.bitCount(), new Random());
    }

    public BigInteger publicKey(BigInteger p, BigInteger g,
                                BigInteger privateKey) {

        return g.modPow(privateKey, p);
    }

    public BigInteger secret(BigInteger primeA, BigInteger bPublicKey,
                             BigInteger aPrivateKey) {

        return bPublicKey.modPow(aPrivateKey, primeA);
    }
}