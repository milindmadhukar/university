-- Sample data for development environment
-- This script will be executed after the application creates the tables

-- Wait for tables to be created by the application
-- This script is designed to be run manually or by the application after startup

-- Note: The Spring Boot application will create the tables automatically
-- This script contains sample data that can be inserted after the first startup

-- Sample books data for development and testing
-- You can run this manually in pgAdmin or through the application

/*
INSERT INTO books (title, author, isbn, genre, publication_date, total_copies, available_copies, description) VALUES
('The Great Gatsby', 'F. Scott Fitzgerald', '978-0-7432-7356-5', 'Fiction', '1925-04-10', 5, 5, 'A classic American novel set in the Jazz Age, exploring themes of wealth, love, and the American Dream.'),
('To Kill a Mockingbird', 'Harper Lee', '978-0-06-112008-4', 'Fiction', '1960-07-11', 3, 3, 'A gripping tale of racial injustice and childhood innocence in the American South.'),
('1984', 'George Orwell', '978-0-452-28423-4', 'Science Fiction', '1949-06-08', 4, 4, 'A dystopian social science fiction novel about totalitarian control and surveillance.'),
('Pride and Prejudice', 'Jane Austen', '978-0-14-143951-8', 'Romance', '1813-01-28', 3, 3, 'A romantic novel that critiques the British landed gentry at the end of the 18th century.'),
('The Catcher in the Rye', 'J.D. Salinger', '978-0-316-76948-0', 'Fiction', '1951-07-16', 2, 2, 'A controversial coming-of-age story told by the teenage protagonist Holden Caulfield.'),
('Harry Potter and the Philosopher''s Stone', 'J.K. Rowling', '978-0-7475-3269-9', 'Fantasy', '1997-06-26', 6, 6, 'The first book in the beloved Harry Potter series about a young wizard''s adventures.'),
('The Lord of the Rings', 'J.R.R. Tolkien', '978-0-618-00222-1', 'Fantasy', '1954-07-29', 4, 4, 'An epic high fantasy novel about the quest to destroy the One Ring.'),
('Dune', 'Frank Herbert', '978-0-441-17271-9', 'Science Fiction', '1965-08-01', 3, 3, 'A science fiction epic set in a distant future amidst a feudal interstellar society.'),
('The Hobbit', 'J.R.R. Tolkien', '978-0-547-92822-7', 'Fantasy', '1937-09-21', 5, 5, 'A children''s fantasy novel about the adventure of Bilbo Baggins.'),
('Brave New World', 'Aldous Huxley', '978-0-06-085052-4', 'Science Fiction', '1932-01-01', 2, 2, 'A dystopian novel that anticipates developments in reproductive technology and psychological manipulation.');
*/

-- You can copy and paste the above INSERT statements into pgAdmin or run them through the application