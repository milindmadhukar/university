package main;
import books.Novel;
import inventory.BookInventory;

// Create a package named main and create a class BookstoreApp within it.
//
//    - In BookstoreApp, create a subclass MysteryNovel of Novel and a subclass Bookstore of BookInventory. Both MysteryNovel and Bookstore should override the methods from their respective parent classes, i.e., read() in MysteryNovel and getStockQuantity() in Bookstore.

class BookstoreApp {
  class MysteryNovel extends Novel {
    public void read() {
      System.out.println("Reading a Mystery Novel.");
    }
  }

  class Bookstore extends BookInventory {
    public Bookstore(int stockQuantity) {
      super(stockQuantity);
    }

    public int getStockQuantity() {
      return super.getStockQuantity();
    }
  }

  public static void main(String[] args) {
    BookstoreApp app = new BookstoreApp();
    BookstoreApp.MysteryNovel novel = app.new MysteryNovel();
    BookstoreApp.Bookstore store = app.new Bookstore(10);

    novel.read();
    System.out.println(store.getStockQuantity());
  }
}
