package com.example.demo.DTO;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private String type;
    private AuthorDTO author; // A reference to the book's Author
}
