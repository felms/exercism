import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if (square <= 0 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return new BigInteger("2").pow(square - 1);
    }

    BigInteger grainsOnBoard() {
        BigInteger r = new BigInteger("2");
        return BigInteger.ONE
                    .multiply(BigInteger.ONE.subtract(r.pow(64)))
                    .divide(BigInteger.ONE.subtract(r));
    }

}
