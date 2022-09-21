import java.util.Objects;

public class BinaryTree {

    private final Zipper rootNode;

    public BinaryTree(int value) {
        this(new Zipper(value));
    }

    public BinaryTree(Zipper zipper) {
        this.rootNode = zipper;
    }

    public Zipper getRoot() {

        Zipper zipper = this.rootNode;

        while (zipper.up != null) {
            zipper = zipper.up;
        }

        return zipper;
    }

    public String printTree() {
        return this.getRoot().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTree that = (BinaryTree) o;
        return Objects.equals(rootNode, that.rootNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rootNode);
    }

}
