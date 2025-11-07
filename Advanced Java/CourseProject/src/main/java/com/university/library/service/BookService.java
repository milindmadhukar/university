package com.university.library.service;

import com.university.library.entity.Book;
import com.university.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    
    private final BookRepository bookRepository;
    
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    // CREATE - Add a new book
    public Book saveBook(Book book) {
        // Ensure available copies equals total copies for new books
        if (book.getId() == null) {
            book.setAvailableCopies(book.getTotalCopies());
        }
        return bookRepository.save(book);
    }
    
    // READ - Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    // READ - Get book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
    
    // READ - Get book by ISBN
    public Optional<Book> getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
    
    // READ - Search books by various criteria
    public List<Book> searchBooks(String searchTerm) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return getAllBooks();
        }
        return bookRepository.searchBooks(searchTerm.trim());
    }
    
    // READ - Get books by author
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }
    
    // READ - Get books by title
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
    
    // READ - Get books by genre
    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenreIgnoreCase(genre);
    }
    
    // READ - Get available books
    public List<Book> getAvailableBooks() {
        return bookRepository.findByAvailableCopiesGreaterThan(0);
    }
    
    // UPDATE - Update existing book
    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id)
            .map(book -> {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setIsbn(updatedBook.getIsbn());
                book.setPublicationDate(updatedBook.getPublicationDate());
                book.setGenre(updatedBook.getGenre());
                book.setDescription(updatedBook.getDescription());
                
                // Handle copy updates carefully
                if (updatedBook.getTotalCopies() != null) {
                    int difference = updatedBook.getTotalCopies() - book.getTotalCopies();
                    book.setTotalCopies(updatedBook.getTotalCopies());
                    book.setAvailableCopies(book.getAvailableCopies() + difference);
                }
                
                return bookRepository.save(book);
            })
            .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }
    
    // DELETE - Delete book by ID
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }
    
    // Business logic - Borrow a book
    public Book borrowBook(Long id) {
        return bookRepository.findById(id)
            .map(book -> {
                if (book.getAvailableCopies() > 0) {
                    book.setAvailableCopies(book.getAvailableCopies() - 1);
                    return bookRepository.save(book);
                } else {
                    throw new RuntimeException("No copies available for borrowing");
                }
            })
            .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }
    
    // Business logic - Return a book
    public Book returnBook(Long id) {
        return bookRepository.findById(id)
            .map(book -> {
                if (book.getAvailableCopies() < book.getTotalCopies()) {
                    book.setAvailableCopies(book.getAvailableCopies() + 1);
                    return bookRepository.save(book);
                } else {
                    throw new RuntimeException("All copies are already returned");
                }
            })
            .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }
    
    // Utility - Check if book exists
    public boolean bookExists(Long id) {
        return bookRepository.existsById(id);
    }
    
    // Utility - Check if ISBN exists
    public boolean isbnExists(String isbn) {
        return bookRepository.findByIsbn(isbn).isPresent();
    }
    
    // Utility - Get total number of books
    public long getTotalBooksCount() {
        return bookRepository.count();
    }
}