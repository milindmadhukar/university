#include <stdio.h>
#include <stdlib.h>

// Node structure for the polynomial
struct Node {
  int coefficient;
  int exp;
  struct Node *next;
};

struct Node *create_node(int coeff, int exp) {
  struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
  newNode->coefficient = coeff;
  newNode->exp = exp;
  newNode->next = NULL;
  return newNode;
}

void insert_node(struct Node **poly, int coeff, int exp) {
  struct Node *newNode = create_node(coeff, exp);
  if (*poly == NULL) {
    *poly = newNode;
  } else {
    struct Node *temp = *poly;
    while (temp->next != NULL) {
      temp = temp->next;
    }
    temp->next = newNode;
  }
}

// Function to add two polynomials
struct Node *add_polynomial(struct Node *poly1, struct Node *poly2) {
  struct Node *result = NULL;
  while (poly1 != NULL && poly2 != NULL) {
    if (poly1->exp > poly2->exp) {
      insert_node(&result, poly1->coefficient, poly1->exp);
      poly1 = poly1->next;
    } else if (poly1->exp < poly2->exp) {
      insert_node(&result, poly2->coefficient, poly2->exp);
      poly2 = poly2->next;
    } else {
      insert_node(&result, poly1->coefficient + poly2->coefficient, poly1->exp);
      poly1 = poly1->next;
      poly2 = poly2->next;
    }
  }
  while (poly1 != NULL) {
    insert_node(&result, poly1->coefficient, poly1->exp);
    poly1 = poly1->next;
  }
  while (poly2 != NULL) {
    insert_node(&result, poly2->coefficient, poly2->exp);
    poly2 = poly2->next;
  }
  return result;
}

void display_polynomial(struct Node *poly) {
  while (poly != NULL) {
    printf("%dx^%d ", poly->coefficient, poly->exp);
    if (poly->next != NULL) {
      printf("+ ");
    }
    poly = poly->next;
  }
  printf("\n");
}

int main() {
  struct Node *poly1 = NULL;
  struct Node *poly2 = NULL;
  struct Node *result = NULL;

  // first polynomial
  insert_node(&poly1, 5, 4);
  insert_node(&poly1, 2, 2);
  insert_node(&poly1, 3, 1);
  printf("Polynomial 1: ");
  display_polynomial(poly1);
  
  // second polynomial
  insert_node(&poly2, 1, 3);
  insert_node(&poly2, 2, 2);
  insert_node(&poly2, 1, 0);
  printf("Polynomial 2: ");
  display_polynomial(poly2);

  // Adding two polynomials
  result = add_polynomial(poly1, poly2);
  printf("Sum of polynomials: ");
  display_polynomial(result);

  return 0;
}
