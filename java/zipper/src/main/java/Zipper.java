import java.util.Objects;

public class Zipper {

    private int value;
    public Zipper left;
    public Zipper right;
    public Zipper up;

    public Zipper(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.up = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(Zipper left) {
        this.left = left;

        if (this.left != null) {
            this.left.setUp(this);
        }
    }

    public void setRight(Zipper right) {
        this.right = right;

        if (this.right != null) {
            this.right.setUp(this);
        }
    }

    public void setUp(Zipper up) {
        this.up = up;
    }

    public BinaryTree toTree() {

        Zipper zipper  = this.clone();

        while (zipper.up != null) {
            zipper = zipper.up;
        }

        return new BinaryTree(zipper);
    }

    public Zipper clone() {
        Zipper zipper = new Zipper(this.getValue());
        zipper.setLeft(this.left);
        zipper.setRight(this.right);
        zipper.setUp(this.up);

        return zipper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zipper zipper = (Zipper) o;
        return value == zipper.value && Objects.equals(left, zipper.left) && Objects.equals(right, zipper.right) && Objects.equals(up, zipper.up);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right, up);
    }

    @Override
    public String toString() {
        return "value: " + this.value + ", " +
               "left: " + (left == null ? "null" : "{ " + left + " }") + ", " +
               "right: " + (right == null ? "null" : "{ " + right + " }");
    }
}