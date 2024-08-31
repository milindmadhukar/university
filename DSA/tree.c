#include <stdio.h>
#include <stdlib.h>

struct Node {
  char data;
  struct Node *left;
  struct Node *right;
};

struct BinaryTree {
  struct Node *root;
};

struct Node *createNode(char data) {
  struct Node *node = (struct Node *)malloc(sizeof(struct Node));
  node->data = data;
  node->left = NULL;
  node->right = NULL;
  return node;
}

void Inorder(struct Node *root) {
  if (root == NULL)
    return;
  Inorder(root->left);
  printf("%c ", root->data);
  Inorder(root->right);
}

void Preorder(struct Node *root) {
  if (root == NULL)
    return;

  printf("%c ", root->data);
  Preorder(root->left);
  Preorder(root->right);
}

void Postorder(struct Node *root) {
  if (root == NULL)
    return;
  Postorder(root->left);
  Postorder(root->right);
  printf("%c ", root->data);
}

int main() {

  struct BinaryTree *bt =
      (struct BinaryTree *)malloc(sizeof(struct BinaryTree));

  struct Node *a = createNode('A');
  struct Node *b = createNode('B');
  struct Node *c = createNode('C');
  struct Node *d = createNode('D');
  struct Node *e = createNode('E');
  struct Node *f = createNode('F');
  struct Node *g = createNode('G');
  struct Node *h = createNode('H');
  struct Node *i = createNode('I');

  bt->root = a;
  a->left = b;
  a->right = c;
  b->left = d;
  d->right = g;
  c->left = e;
  c->right = f;
  e->left = h;
  e->right = i;

  Postorder(bt->root);
  printf("\n");

  return 0;
}
