// Create a binary search tree using linked list. And perform In-order,
// Pre-order and Post-order traversals.

#include <stdio.h>
#include <stdlib.h>

struct Node {
  int data;
  struct Node *left;
  struct Node *right;
};

struct BST {
  struct Node *root;
};

struct Node *create_node(int data) {
  struct Node *node = (struct Node *)malloc(sizeof(struct Node));
  node->data = data;
  node->left = NULL;
  node->right = NULL;
  return node;
}

struct Node *insert(struct Node *root, int data) {
  if (root == NULL) {
    return create_node(data);
  }
  if (data < root->data) {
    root->left = insert(root->left, data);
  } else if (data > root->data) {
    root->right = insert(root->right, data);
  }
  return root;
}

struct BST *create_bst() {
  struct BST *bst = (struct BST *)malloc(sizeof(struct BST));
  bst->root = NULL;
  return bst;
}

void print_between_k1_k2(struct Node *root, int k1, int k2) {
  if (root == NULL) {
    return;
  }

  printf("%d, ", root->data);
  if (root->data < k2) {
    print_between_k1_k2(root->right, k1, k2);
  }

  else if (root->data > k1) {
    print_between_k1_k2(root->left, k1, k2);
  }
}

int main() {

  int arr[10] = {12, 15, 6, 12, 65, 76, 45, 43, 77, 89};

  struct BST *bst = create_bst();

  for (int i = 0; i < sizeof(arr) / sizeof(int); i++) {
    bst->root = insert(bst->root, arr[i]);
  }

  print_between_k1_k2(bst->root, 10, 55);

  return 0;
}
