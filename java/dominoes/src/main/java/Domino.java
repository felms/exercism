import java.util.Objects;

class Domino {
    private final int left;
    private final int right;
    Domino(int left, int right) {
        this.left = left;
        this.right = right;
    }
    
    int getLeft() {
        return this.left;
    }
    
    int getRight() {
        return this.right;
    }
    
    @Override
    public boolean equals(Object o) {
        Domino otherDomino = (Domino) o;
        return (this.getLeft() == otherDomino.getLeft() && this.getRight() == otherDomino.getRight()) ||
            (this.getLeft() == otherDomino.getRight() && this.getRight() == otherDomino.getLeft());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
