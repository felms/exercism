class TreeNode:
    def __init__(self, data, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right

    def __str__(self):
        return f'TreeNode(data={self.data}, left={self.left}, right={self.right})'


class BinarySearchTree:
    def __init__(self, tree_data):

        self.root = None

        for item in tree_data:
            self.root = BinarySearchTree.insert_data(self.root, item)

    @staticmethod
    def insert_data(current_node, data):

        if not current_node:
            return TreeNode(data, None, None)

        if int(data) <= int(current_node.data):
            return TreeNode(
                current_node.data,
                BinarySearchTree.insert_data(current_node.left, data),
                current_node.right
            )

        return TreeNode(
            current_node.data,
            current_node.left,
            BinarySearchTree.insert_data(current_node.right, data)
        )

    def data(self):
        return self.root

    def sorted_data(self):
        return BinarySearchTree.get_sorted_data(self.root)

    @staticmethod
    def get_sorted_data(root_node):
        if not root_node:
            return []

        return BinarySearchTree.get_sorted_data(root_node.left) + \
            [root_node.data] + \
            BinarySearchTree.get_sorted_data(root_node.right)
