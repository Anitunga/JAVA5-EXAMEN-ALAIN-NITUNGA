package com.example.demo.Repository;

import com.example.demo.Entity.Author;
import com.example.demo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitleAndAuthor(String title, Author author);

    @Query("SELECT b FROM Book b WHERE b.author.id = :authorId")
    List<Book> findBooksByAuthorId(@Param("authorId") Long authorId);
}
