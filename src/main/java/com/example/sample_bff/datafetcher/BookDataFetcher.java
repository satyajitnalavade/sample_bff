package com.example.sample_bff.datafetcher;

import com.example.sample_bff.model.Book;
import com.example.sample_bff.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

/** @author satya */
@Component
public class BookDataFetcher implements DataFetcher<Book> {

  private final BookRepository bookRepository;

  public BookDataFetcher(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Book get(DataFetchingEnvironment dataFetchingEnvironment) {
    String isn = dataFetchingEnvironment.getArgument("id");
    return bookRepository.findById(isn).orElse(null);
  }
}
