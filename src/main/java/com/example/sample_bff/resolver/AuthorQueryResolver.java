package com.example.sample_bff.resolver;

import com.example.sample_bff.model.Author;
import com.example.sample_bff.service.AuthorService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorQueryResolver implements GraphQLQueryResolver {
    private final AuthorService authorService;

    public AuthorQueryResolver(AuthorService authorService) {
        this.authorService = authorService;
    }

    public List<Author> authors() {
        return authorService.getAllAuthors();
    }
}
