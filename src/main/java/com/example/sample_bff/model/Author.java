package com.example.sample_bff.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(
            cascade = { CascadeType.PERSIST, CascadeType.MERGE },
            mappedBy = "authors",
            fetch = FetchType.EAGER
    )
    private Set<Book> books;

    public Author(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        if (this.books == null) {
            this.books = new HashSet<>();
        }
        this.books.add(book);
    }

}
