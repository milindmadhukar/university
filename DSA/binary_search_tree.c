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

int search(struct Node *root, int num) {
  if (root == NULL)
    return -1;
  if (num == root->data)
    return root->data;
  else if (num < root->data)
    return search(root->left, num);
  else if (num > root->data)
    return search(root->right, num);
  return -1;
}

struct BST *create_bst() {
  struct BST *bst = (struct BST *)malloc(sizeof(struct BST));
  bst->root = NULL;
  return bst;
}

struct Node *minValueNode(struct Node *node) {
  struct Node *current = node;

  /* loop down to find the leftmost leaf */
  while (current && current->left != NULL)
    current = current->left;

  return current;
}

struct Node *deleteNode(struct Node *root, int value) {
  // base case
  if (root == NULL)
    return root;

  // If the key to be deleted
  // is smaller than the root's
  // key, then it lies in left subtree
  if (value < root->data)
    root->left = deleteNode(root->left, value);

  // If the key to be deleted
  // is greater than the root's
  // key, then it lies in right subtree
  else if (value > root->data)
    root->right = deleteNode(root->right, value);

  // if key is same as root's key,
  // then This is the node
  // to be deleted
  else {
    // node with only one child or no child
    if (root->left == NULL) {
      struct Node *temp = root->right;
      free(root);
      return temp;
    } else if (root->right == NULL) {
      struct Node *temp = root->left;
      free(root);
      return temp;
    }

    // node with two children:
    // Get the inorder successor
    // (smallest in the right subtree)
    struct Node *temp = minValueNode(root->right);

    // Copy the inorder
    // successor's content to this node
    root->data = temp->data;

    // Delete the inorder successor
    root->right = deleteNode(root->right, temp->data);
  }
  return root;
}

int main() {

  int arr[10] = {12, 15, 6, 12, 65, 76, 45, 43, 77, 89};

  struct BST *bst = create_bst();

  for (int i = 0; i < sizeof(arr) / sizeof(int); i++) {
    bst->root = insert(bst->root, arr[i]);
  }

  inorder(bst->root);
  printf("\n");

  deleteNode(bst -> root, 65);

  inorder(bst->root);

  int ele = search(bst->root, 76);
  printf("\nElement found is: %d\n", ele);

  return 0;
}
