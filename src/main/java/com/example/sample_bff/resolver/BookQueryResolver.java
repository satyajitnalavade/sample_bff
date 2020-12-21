package com.example.sample_bff.resolver;

import com.example.sample_bff.model.Book;
import com.example.sample_bff.repository.AuthorRepository;
import com.example.sample_bff.service.BookService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookQueryResolver implements GraphQLQueryResolver {
    private final BookService bookService;


    public List<Book> books() {
        return bookService.getAllBooks();
    }

    public BookQueryResolver(BookService bookService) {
        this.bookService = bookService;

    }

    public Book getBook(String isbn) {
        return bookService.getBookByIsbn(isbn);
    }

    public Connection<Book> booksPaginated(int first, String after, DataFetchingEnvironment env) {
        List<Book> books = bookService.getAllBooks();
        return new SimpleListConnection<>(books).get(env);
    }

}
