package com.university.library.controller;

import com.university.library.entity.Book;
import com.university.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    
    private final BookService bookService;
    
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    // ============ WEB ENDPOINTS (Thymeleaf Views) ============
    
    // Home page - List all books
    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) String search) {
        List<Book> books;
        if (search != null && !search.trim().isEmpty()) {
            books = bookService.searchBooks(search);
            model.addAttribute("searchTerm", search);
        } else {
            books = bookService.getAllBooks();
        }
        model.addAttribute("books", books);
        model.addAttribute("totalBooks", bookService.getTotalBooksCount());
        return "index";
    }
    
    // Show add book form
    @GetMapping("/books/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book-form";
    }
    
    // Handle add book form submission
    @PostMapping("/books/add")
    public String addBook(@Valid @ModelAttribute Book book, 
                         BindingResult result, 
                         RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "book-form";
        }
        
        try {
            if (bookService.isbnExists(book.getIsbn())) {
                result.rejectValue("isbn", "error.book", "ISBN already exists");
                return "book-form";
            }
            
            bookService.saveBook(book);
            redirectAttributes.addFlashAttribute("successMessage", "Book added successfully!");
            return "redirect:/";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error adding book: " + e.getMessage());
            return "redirect:/books/add";
        }
    }
    
    // Show edit book form
    @GetMapping("/books/edit/{id}")
    public String showEditBookForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "book-form";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Book not found!");
            return "redirect:/";
        }
    }
    
    // Handle edit book form submission
    @PostMapping("/books/edit/{id}")
    public String updateBook(@PathVariable Long id, 
                           @Valid @ModelAttribute Book book, 
                           BindingResult result, 
                           RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            book.setId(id);
            return "book-form";
        }
        
        try {
            // Check if ISBN exists for other books
            Optional<Book> existingBook = bookService.getBookByIsbn(book.getIsbn());
            if (existingBook.isPresent() && !existingBook.get().getId().equals(id)) {
                result.rejectValue("isbn", "error.book", "ISBN already exists");
                book.setId(id);
                return "book-form";
            }
            
            bookService.updateBook(id, book);
            redirectAttributes.addFlashAttribute("successMessage", "Book updated successfully!");
            return "redirect:/";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error updating book: " + e.getMessage());
            return "redirect:/books/edit/" + id;
        }
    }
    
    // Delete book
    @PostMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            bookService.deleteBook(id);
            redirectAttributes.addFlashAttribute("successMessage", "Book deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting book: " + e.getMessage());
        }
        return "redirect:/";
    }
    
    // View book details
    @GetMapping("/books/view/{id}")
    public String viewBook(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "book-details";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Book not found!");
            return "redirect:/";
        }
    }
    
    // Borrow book
    @PostMapping("/books/borrow/{id}")
    public String borrowBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            bookService.borrowBook(id);
            redirectAttributes.addFlashAttribute("successMessage", "Book borrowed successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/books/view/" + id;
    }
    
    // Return book
    @PostMapping("/books/return/{id}")
    public String returnBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            bookService.returnBook(id);
            redirectAttributes.addFlashAttribute("successMessage", "Book returned successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/books/view/" + id;
    }
    
    // ============ REST API ENDPOINTS ============
    
    // GET all books
    @GetMapping("/api/books")
    @ResponseBody
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }
    
    // GET book by ID
    @GetMapping("/api/books/{id}")
    @ResponseBody
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }
    
    // POST create new book
    @PostMapping("/api/books")
    @ResponseBody
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        try {
            if (bookService.isbnExists(book.getIsbn())) {
                return ResponseEntity.badRequest().build();
            }
            Book savedBook = bookService.saveBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    // PUT update book
    @PutMapping("/api/books/{id}")
    @ResponseBody
    public ResponseEntity<Book> updateBookApi(@PathVariable Long id, @Valid @RequestBody Book book) {
        try {
            Book updatedBook = bookService.updateBook(id, book);
            return ResponseEntity.ok(updatedBook);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // DELETE book
    @DeleteMapping("/api/books/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteBookApi(@PathVariable Long id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // GET search books
    @GetMapping("/api/books/search")
    @ResponseBody
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String q) {
        List<Book> books = bookService.searchBooks(q);
        return ResponseEntity.ok(books);
    }
    
    // POST borrow book
    @PostMapping("/api/books/{id}/borrow")
    @ResponseBody
    public ResponseEntity<Book> borrowBookApi(@PathVariable Long id) {
        try {
            Book book = bookService.borrowBook(id);
            return ResponseEntity.ok(book);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    // POST return book
    @PostMapping("/api/books/{id}/return")
    @ResponseBody
    public ResponseEntity<Book> returnBookApi(@PathVariable Long id) {
        try {
            Book book = bookService.returnBook(id);
            return ResponseEntity.ok(book);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}