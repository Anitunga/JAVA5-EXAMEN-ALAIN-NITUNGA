package com.example.demo.Service;

import com.example.demo.Entity.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> getAllAuthors();

    Author getAuthorById(Long id);

    Author createAuthor(Author author);
}
