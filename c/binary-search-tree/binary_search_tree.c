#include "binary_search_tree.h"

#include <stdlib.h>
#include <string.h>

node_t *insert(node_t *root, int data);
int tree_size(node_t *tree);

node_t *build_tree(int *tree_data, size_t tree_data_len) {

    node_t *root = NULL;

    for (size_t i = 0; i < tree_data_len; i++) {
        root = insert(root, tree_data[i]);
    }

    return root;
}


node_t *insert(node_t *root, int data) {
    
    if (!root) {
        node_t *new_node = malloc(sizeof (node_t));
        new_node->data = data;
        new_node->left = NULL;
        new_node->right = NULL;

        return new_node;
    }

    if (data <= root->data) {
        root->left = insert(root->left, data);
    }

    if (data > root->data) {
        root->right = insert(root->right, data);
    }

    return root;
}

void free_tree(node_t *tree) {

    if (tree->left == NULL && tree->right == NULL) {
        free(tree);
        return;
    }

    if (tree->left) {
        free_tree(tree->left);
    }

    if (tree->right) {
        free_tree(tree->right);
    }

}


int *sorted_data(node_t *tree) {

    if (!tree) {
        return NULL;
    }

    int* left_data = sorted_data(tree->left);
    int left_size = tree_size(tree->left);

    int* current = &(tree->data);

    int* right_data = sorted_data(tree->right);
    int right_size = tree_size(tree->right);

    int total_size = left_size + 1 + right_size;

    int* total_data = malloc(total_size * sizeof(int));

    memcpy(total_data, left_data, left_size * sizeof(int));
    memcpy(total_data + left_size, current, 1 * sizeof(int));
    memcpy(total_data + (left_size + 1), right_data, right_size * sizeof(int));

    return total_data;

}

int tree_size(node_t *tree) {

    if (!tree) {
        return 0;
    }

    return tree_size(tree->left) + 1 + tree_size(tree->right);
}


