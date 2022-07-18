import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Satellite {

    private final List<Character> preorder;
    private final List<Character> postorder;
    private int current;

    public Satellite() {
        this.preorder = new ArrayList<>();
        this.postorder = new ArrayList<>();
        this.current = 0;
    }

    public Tree treeFromTraversals(List<Character> preorder, List<Character> postorder) {
        this.preorder.addAll(preorder);
        this.postorder.addAll(postorder);

        if (this.preorder.size() != this.postorder.size()) {
            throw new IllegalArgumentException("traversals must have the same length");
        }

        Set<Character> pre = new HashSet<>(preorder);
        Set<Character> post = new HashSet<>(postorder);

        if (!pre.equals(post)) {
            throw new IllegalArgumentException("traversals must have the same elements");
        }

        if (pre.size() != preorder.size() || post.size() != postorder.size()) {
            throw new IllegalArgumentException("traversals must contain unique items");
        }

        Node root = buildTree(0, postorder.size() - 1);

        return new Tree(root);
    }

    private Node buildTree(int left, int right) {

        if (left > right) {
            return null;
        }

        char root = this.preorder.get(this.current);
        this.current++;

        int middle = this.postorder.indexOf(root);

        Node node = new Node(root);

        node.left = buildTree(left, middle - 1);
        node.right = buildTree(middle + 1, right);

        return node;
    }
}