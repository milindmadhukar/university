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

void inorder(struct Node *root) {
  if (root == NULL)
    return;
  inorder(root->left);
  printf("%d ", root->data);
  inorder(root->right);
}

struct BST *create_bst() {
  struct BST *bst = (struct BST *)malloc(sizeof(struct BST));
  bst->root = NULL;
  return bst;
}

struct Node *find_minimum(struct Node *root) {
  if (root == NULL)
    return NULL;
  if (root->left == NULL)
    return root;
  return find_minimum(root->left);
}

struct Node *find_maximum(struct Node *root) {
  if (root == NULL)
    return NULL;
  if (root->right == NULL)
    return root;
  return find_maximum(root->right);
}

struct Node *find_kth_smallest(struct Node *root, int k, int *count) {
  if (root == NULL)
    return NULL;
  struct Node *left = find_kth_smallest(root->left, k, count);
  if (left != NULL)
    return left;
  (*count)++;
  if (*count == k)
    return root;
  return find_kth_smallest(root->right, k, count);
}

int main() {

  int arr[7] = {40, 30, 50, 20, 35, 45, 55};

  struct BST *bst = create_bst();

  for (int i = 0; i < sizeof(arr) / sizeof(int); i++) {
    bst->root = insert(bst->root, arr[i]);
  }

  inorder(bst->root);
  printf("\n");

  printf("Smallest element is: %d\n", find_minimum(bst->root)->data);
  printf("Largest element is: %d\n", find_maximum(bst->root)->data);

  int count = 0;
  int k = 3;
  struct Node *kth_smallest_node = find_kth_smallest(bst->root, k, &count);
  printf("%dth smallest element in the tree: %d\n", k, kth_smallest_node -> data);

  return 0;
}
