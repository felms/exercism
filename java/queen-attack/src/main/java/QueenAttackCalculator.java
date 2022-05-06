public class QueenAttackCalculator {

    public Queen queen01;
    public Queen queen02;

    public QueenAttackCalculator(Queen queen1, Queen queen2) {

        if (queen1 == null || queen2 == null) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }

        if (queen1.getRow() == queen2.getRow() && queen1.getColumn() == queen2.getColumn()) {
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }

        this.queen01 = queen1;
        this.queen02 = queen2;
    }

    public boolean canQueensAttackOneAnother() {

        // Mesma linha ou mesma coluna
        if (this.queen01.getRow() == this.queen02.getRow()
            || this.queen01.getColumn() == this.queen02.getColumn()) {
                return true;
        }

        // Diagonais secundarias
        if (this.queen01.getRow() + this.queen01.getColumn() == this.queen02.getRow() + this.queen02.getColumn()) {
            return true;
        }

        // Diagonais principais
        if (this.queen01.getRow() - this.queen01.getColumn() == this.queen02.getRow() - this.queen02.getColumn()) {
            return true;
        }

        return false;
    }


}

class Queen {

    private final int row;
    private final int column;

    public Queen(int row, int column) {

        if (row > 7) {
            throw new IllegalArgumentException("Queen position must have row <= 7.");
        }

        if (column > 7) {
            throw new IllegalArgumentException("Queen position must have column <= 7.");
        }

        if (row < 0) {
            throw new IllegalArgumentException("Queen position must have positive row.");
        }

        if (column < 0) {
            throw new IllegalArgumentException("Queen position must have positive column.");
        } 

        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
}
