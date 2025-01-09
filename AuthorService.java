package com.example.demo.Service;

import com.example.demo.DAO.AuthorDAO;
import com.example.demo.Entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    public List<Author> getAllAuthors() {
        return authorDAO.findAll();
    }

    @Override
    public Author createAuthor(Author author) {
        return authorDAO.save(author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorDAO.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

}
