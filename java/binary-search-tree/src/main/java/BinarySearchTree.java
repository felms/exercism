import java.util.ArrayList;
import java.util.List;

class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root = null;

    void insert(T value) {
        if(this.root == null) {
            this.root = new Node<>(value);
        } else {
            this.root = insertChild(this.root, value);
        }
    }

    List<T> getAsSortedList() {
        List<T> res = new ArrayList<>();
        inOrder(this.root, res);
        return res;
    }

    private void inOrder(Node<T> node, List<T> list) {

        if(node == null) {
            return;
        }

        inOrder(node.getLeft(), list);
        list.add(node.getData());
        inOrder(node.getRight(), list);
    }

    List<T> getAsLevelOrderList() {
        List<T> res = new ArrayList<>();
        List<Node<T>> queue = new ArrayList<>();

        queue.add(this.root);

        while(!queue.isEmpty()) {
            Node<T> node = queue.remove(0);
            res.add(node.getData());
            
            Node<T> left = node.getLeft();
            if(left != null) {
                queue.add(left);
            }

            Node<T> right = node.getRight();
            if(right != null) {
                queue.add(right);
            }
        }

        return res;
    }

    Node<T> getRoot() {
        return this.root;
    }

    Node<T> insertChild(Node<T> node, T data) {
        if(node == null) {
            return new Node<>(data);
        }

        if(data.compareTo(node.getData()) <= 0) {
            return new Node<>(
                    node.getData(),
                    insertChild(node.getLeft(), data),
                    node.getRight());
        }

        return new Node<>(
                node.getData(),
                node.getLeft(),
                insertChild(node.getRight(), data));

    }

    static class Node<T> {

        private T data;
        private Node<T> left;
        private Node<T> right;

        Node(T data) {
            this(data, null, null);
        }

        Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
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
