package com.example.demo;

import com.example.demo.Controller.AuthorController;
import com.example.demo.Entity.Author;
import com.example.demo.Service.AuthorService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthorControllerTest {

    @InjectMocks
    private AuthorController authorController;

    @Mock
    private AuthorService authorService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();
    }

    @Test
    public void testGetAllAuthors() throws Exception {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author());

        when(authorService.getAllAuthors()).thenReturn(authors);

        mockMvc.perform(get("/authors"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAuthorById() throws Exception {
        Author author = new Author();
        author.setId(1L);

        when(authorService.getAuthorById(1L)).thenReturn(author);

        mockMvc.perform(get("/authors/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateAuthor() throws Exception {
        Author author = new Author();
        author.setFirstname("David");
        author.setLastname("Goggins");

        when(authorService.createAuthor(author)).thenReturn(author);

        mockMvc.perform(post("/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(author)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteAuthor() throws Exception {
        mockMvc.perform(delete("/authors/1"))
                .andExpect(status().isNoContent());
    }
}