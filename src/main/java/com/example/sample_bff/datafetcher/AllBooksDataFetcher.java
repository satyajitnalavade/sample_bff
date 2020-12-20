package com.example.sample_bff.datafetcher;

import com.example.sample_bff.model.Book;
import com.example.sample_bff.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author satya
 */
@Component
public class AllBooksDataFetcher implements DataFetcher<List<Book>> {

    private final BookRepository bookRepository;

    public AllBooksDataFetcher(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return bookRepository.findAll();
    }
}
