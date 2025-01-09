package com.example.demo.Service;

import com.example.demo.Entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book createBook(Book book);

    void updateBook(Book book);

    void deleteBook(Long id);

    List<Book> findBooksByAuthorId(Long authorId);
}
