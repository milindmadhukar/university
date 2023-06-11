// Create a binary search tree using linked list. And perform In-order, Pre-order and Post-order traversals. 

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


void preorder(struct Node *root) {
  if (root == NULL)
    return;
  printf("%d ", root->data);
  inorder(root->left);
  inorder(root->right);
}


void postorder(struct Node *root) {
  if (root == NULL)
    return;
  inorder(root->left);
  inorder(root->right);
  printf("%d ", root->data);
}


struct BST *create_bst() {
  struct BST *bst = (struct BST *)malloc(sizeof(struct BST));
  bst->root = NULL;
  return bst;
}

int main() {

  int arr[10] = {12, 15, 6, 12, 65, 76, 45, 43, 77, 89};

  struct BST *bst = create_bst();

  for (int i = 0; i < sizeof(arr) / sizeof(int); i++) {
    bst->root = insert(bst->root, arr[i]);
  }

  inorder(bst->root);
  printf("\n");

  preorder(bst->root);
  printf("\n");


  postorder(bst->root);
  printf("\n");


  return 0;
}
