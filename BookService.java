package com.example.demo.Service;

import com.example.demo.DAO.AuthorDAO;
import com.example.demo.DAO.BookDAO;
import com.example.demo.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookDAO.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public Book createBook(Book book) {
        return bookDAO.save(book);
    }

    @Override
    public void updateBook(Book book) {
        Book existingBook = bookDAO.findById(book.getId())
                .orElseThrow(() -> new RuntimeException("Book not found"));
        existingBook.setTitle(book.getTitle());
        existingBook.setBookType(book.getBookType());
        existingBook.setAuthor(book.getAuthor());
        bookDAO.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookDAO.deleteById(id);
    }

    @Override
    public List<Book> findBooksByAuthorId(Long authorId) {
        authorDAO.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        return bookDAO.findBooksByAuthorId(authorId);
    }
}
