import java.util.*;

class Tree {
    private final String label;
    private final List<Tree> children;

    public Tree(String label) {
        this(label, new ArrayList<>());
    }

    public Tree(String label, List<Tree> children) {
        this.label = label;
        this.children = children;
    }

    public static Tree of(String label) {
        return new Tree(label);
    }

    public static Tree of(String label, List<Tree> children) {
        return new Tree(label, children);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return label.equals(tree.label)
                && children.size() == tree.children.size()
                && children.containsAll(tree.children)
                && tree.children.containsAll(children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, children);
    }

    @Override
    public String toString() {
        return "Tree{" + label +
                ", " + children +
                "}";
    }

    public Tree fromPov(String fromNode) {

        if (!containsNode(fromNode, this)) {
            throw new UnsupportedOperationException("Tree could not be reoriented");
        }

        return fromPov(fromNode, this);
    }

    public List<String> pathTo(String fromNode, String toNode) {

        if (!containsNode(fromNode, this) || !containsNode(toNode, this)) {
           throw new UnsupportedOperationException("No path found");
        }

        Tree searchTree = fromPov(fromNode, this);
        List<String> res = new ArrayList<>();
        res.add(fromNode);

        while (!fromNode.equals(toNode)) {
            Tree searchedSubtree = searchTree.children.stream()
                    .filter(childTree -> containsNode(toNode, childTree)).findFirst().get();

            res.add(searchedSubtree.label);

            fromNode = searchedSubtree.label;
            searchTree = searchedSubtree;
        }

        return res;
    }

    private static Tree fromPov(String fromNode, Tree currentTree) {
        if (currentTree.label.equals(fromNode)) {
            return currentTree;
        }

        Tree cutUpTree = Tree.of(currentTree.label,
                currentTree.children.stream()
                        .filter(childTree -> !containsNode(fromNode, childTree)).toList()
        );

        Tree searchedSubtree = currentTree.children.stream()
                .filter(childTree -> containsNode(fromNode, childTree)).findFirst().get();

        List<Tree> newChildren = new ArrayList<>(searchedSubtree.children);
        newChildren.add(cutUpTree);

        Tree newTree = Tree.of((searchedSubtree.label), newChildren);

        return fromPov(fromNode, newTree);
    }

    private static boolean containsNode(String searchedNode, Tree tree) {
        if (tree.label.equals(searchedNode)) {
            return true;
        }

        return tree.children.stream().anyMatch(currTree -> containsNode(searchedNode, currTree));

    }
}
