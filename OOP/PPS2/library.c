#include <stdio.h>
#include <string.h>

struct Book {
  int num;
  char name[100];
  char author[100];
  int pages;
};

struct Book library[100];
int book_count = 0;

void add_books() {
  int amount;
  printf("How Many Records You Want to Add: ");
  scanf("%d", &amount);
  getchar();
  printf("-------------------------------------\n"
         "Add Details of %d Book\n",
         amount);
  for (int i = 0; i < amount; i++) {
    printf("-------------------------------------\n");
    printf("Enter Book No.\t:");
    scanf("%d", &library[book_count].num);
    getchar();
    printf("Book Name\t:");
    fgets(library[book_count].name, 50, stdin);
    library[book_count].name[strcspn(library[book_count].name, "\n")] = 0;
    printf("Enter Author Name\t:");
    fgets(library[book_count].author, 50, stdin);
    library[book_count].author[strcspn(library[book_count].author, "\n")] = 0;
    printf("Enter No. of Pages :");
    scanf("%d", &library[book_count].pages);
    book_count++;
  }
}

void display() {
  printf("Details of All Book\n"
         "---------------------------------------------------------------------"
         "--------------------------------------------------------\n");

  printf("Book No.\tBook Name\t\tAuthor Name\t\tNo. of Pages\n");
  struct Book current_book;
  for (int i = 0; i < book_count; i++) {
    current_book = library[i];
    printf("%d\t\t%s\t\t%s\t\t%d\n", current_book.num, current_book.name,
           current_book.author, current_book.pages);
  }
}

void list_book_by_author() {
  char author[100];
  scanf("%s", author);

  struct Book current_book;
  int matches = 0;

  for (int i = 0; i < book_count; i++) {
    current_book = library[i];
    if (strcmp(author, current_book.author) == 0) {
      printf("%s\n", current_book.name);
      matches++;
    }
  }

  if (matches == 0) {
    printf("No match found\n");
  }
}

void display_book_count() { printf("%d", book_count); }

int main() {
  printf("MENU\n-------------------------------------\n"
         "PRESS 1.TO ADD BOOK DETAILS.\n"
         "PRESS 2.TO DISPLAY BOOK DETAILS.\n"
         "PRESS 3.TO DISPLAY BOOK OF GIVEN AUTHOR.\n"
         "PRESS 4.TO COUNT NUMBER OF BOOKS.\n"
         "PRESS 5.TO EXIT.\n"
         "-------------------------------------\n");

  int choice = -1;
  while (choice != 5) {
    printf("Enter Your Choice: ");
    scanf("%d", &choice);
    switch (choice) {
    case 1:
      add_books();
      break;
    case 2:
      display();
      break;
    case 3:
      list_book_by_author();
      break;
    case 4:
      display_book_count();
    default:
      printf("invalid");
    }
  }
  return 0;
}
