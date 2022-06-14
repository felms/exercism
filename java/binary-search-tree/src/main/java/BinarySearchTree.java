import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    void insert(T value) {
        Node<T> node = new Node<>(value);

        if (this.root == null) {
            this.root = node;
        } else {
            Node<T> currentNode = this.getRoot();
            boolean inserted = false;

            while (!inserted) {
                if (value.compareTo(currentNode.getData()) > 0) {

                    if (currentNode.right == null) {
                        currentNode.right = node;
                        inserted = true;
                    } else {
                        currentNode = currentNode.right;
                    }

                } else {
                    if (currentNode.left == null) {
                        currentNode.left = node;
                        inserted = true;
                    } else {
                        currentNode = currentNode.left;
                    }
                }
            }
            
        }
    }

    List<T> getAsSortedList() {
        List<T> treeData = new ArrayList<>();
        inOrderTraversal(this.root, treeData);
        return treeData;
    }

    List<T> getAsLevelOrderList() {

        List<T> treeData = new ArrayList<>();
        Queue<Node<T>> nodesQueue = new ArrayDeque<>();
        nodesQueue.add(this.getRoot());

        while (!nodesQueue.isEmpty()) {
            Node<T> node = nodesQueue.remove();
            treeData.add(node.getData());

            if (node.getLeft() != null) {
                nodesQueue.add(node.getLeft());
            }

            if (node.getRight() != null) {
                nodesQueue.add(node.getRight());
            }
        }

        return treeData;

    }

    Node<T> getRoot() {
        return this.root;
    }

    private void inOrderTraversal(Node<T> node, List<T> treeData) {

        if (node == null) {
            return;
        }

        inOrderTraversal(node.getLeft(), treeData);
        treeData.add(node.getData());
        inOrderTraversal(node.getRight(), treeData);
    }

    static class Node<T> {

        private Node<T> left;
        private Node<T> right;
        private T data;

        public Node(T data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }

        Node<T> getLeft() {
            return this.left;
        }

        Node<T> getRight() {
            return this.right;
        }

        T getData() {
            return this.data;
        }

    }
}
