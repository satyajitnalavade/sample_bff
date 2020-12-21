package com.example.sample_bff.service;

import com.example.sample_bff.exception.ResourceNotFoundException;
import com.example.sample_bff.model.Author;
import com.example.sample_bff.model.Book;
import com.example.sample_bff.model.BookWrapper;
import com.example.sample_bff.repository.AuthorRepository;
import com.example.sample_bff.repository.BookRepository;
import graphql.GraphQLException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookByIsbn(String isbn) {
        Optional<Book> bookOptional = bookRepository.findById(isbn);
        if (bookOptional.isPresent()) {
            throw new ResourceNotFoundException("Could not find book with isbn: " + isbn);
        }
        return bookOptional.get();
    }

    public Book createBook(BookWrapper bookWrapper) {
        Book book = new Book(bookWrapper.getIsbn(), bookWrapper.getTitle());
        book.setPublishedDate(bookWrapper.getPublishedDate());
        return bookRepository.save(book);
    }

    public Book addAuthorToBook(Long authorId, String isbn) {
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        Optional<Book> bookOptional = bookRepository.findById(isbn);
        if (authorOptional.isPresent() && bookOptional.isPresent()) {
            Book book = bookOptional.get();
            Author author = authorOptional.get();
            book.addAuthor(author);
            bookRepository.save(book);
            return bookOptional.get();
        }
        throw new GraphQLException("couldn't add author");
    }

}
