package com.example.sample_bff.resolver;

import com.example.sample_bff.model.Author;
import com.example.sample_bff.model.AuthorWrapper;
import com.example.sample_bff.service.AuthorService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;


@Component
public class AuthorMutationResolver  implements GraphQLMutationResolver {
    private final AuthorService authorService;

    public AuthorMutationResolver(AuthorService authorService) {
        this.authorService = authorService;
    }

    public Author createAuthor(AuthorWrapper authorWrapper) {
        return authorService.createAuthor(authorWrapper.getName());
    }

    public Author addBook(Long authorId, String isbn) {
        return authorService.addBookToAuthor(authorId, isbn);
    }
}
