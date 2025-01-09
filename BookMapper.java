package com.example.demo.DTO;

import com.example.demo.Entity.Author;
import com.example.demo.Entity.Book;

public class BookMapper {
    public BookDTO toDto(Book book) {
        BookDTO bookDto = new BookDTO();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setType(book.getBookType());
        bookDto.setAuthor(toAuthorDto(book.getAuthor()));
        return bookDto;
    }

    public AuthorDTO toAuthorDto(Author author) {
        AuthorDTO authorDto = new AuthorDTO();
        authorDto.setId(author.getId());
        authorDto.setFirstname(author.getFirstname());
        authorDto.setLastname(author.getLastname());
        return authorDto;
    }
}
