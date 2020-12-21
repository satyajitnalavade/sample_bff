package com.example.sample_bff.service;

import com.example.sample_bff.model.Author;
import com.example.sample_bff.model.Book;
import com.example.sample_bff.repository.AuthorRepository;
import com.example.sample_bff.repository.BookRepository;
import graphql.GraphQLException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author createAuthor(String authorName) {
        return authorRepository.save(new Author(authorName));
    }

    public Author addBookToAuthor(Long authorId, String isbn) {
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        Optional<Book> bookOptional = bookRepository.findById(isbn);
        if (authorOptional.isPresent() && bookOptional.isPresent()) {
            Book book = bookOptional.get();
            Author author = authorOptional.get();
            author.addBook(book);
            authorRepository.save(author);
            return authorOptional.get();
        }
        throw new GraphQLException("couldn't add book to author");
    }
}
