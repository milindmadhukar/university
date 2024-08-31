#include <iostream>
#include <string>

using std::cout;

class Book {
private:
  std::string title;
  std::string author;
  std::string isbn;
  bool isAvailable;

public:
  Book(std::string t, std::string a, std::string i) {
    title = t;
    author = a;
    isbn = i;
    isAvailable = true;
  }

  std::string getTitle() { return title; }

  std::string getAuthor() { return author; }

  std::string getISBN() { return isbn; }

  bool getAvailability() { return isAvailable; }

  void borrowBook() { isAvailable = false; }

  void returnBook() { isAvailable = true; }
};

int main() {
    // Create an array of books
    Book library[3] = {
        Book("The Alchemist", "Paulo Coelho", "978-006231"),
        Book("To Kill a Mockingbird", "Harper Lee", "978-044631"),
        Book("The Catcher in the Rye", "J.D. Salinger", "978-031676")
    };

    // Test the book methods
    std::cout << library[0].getTitle() << std::endl;
    std::cout << library[0].getAuthor() << std::endl;
    std::cout << library[0].getISBN() << std::endl;
    std::cout << library[0].getAvailability() << std::endl;

    library[0].borrowBook();
    cout << library[0].getAvailability() << std::endl;

    library[0].returnBook();
    cout << library[0].getAvailability() << std::endl;

    return 0;
}

