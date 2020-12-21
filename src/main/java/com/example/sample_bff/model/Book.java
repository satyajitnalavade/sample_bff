package com.example.sample_bff.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {

    @Id
    private String isbn;
    private String title;
    private LocalDate publishedDate;
    @ManyToMany(
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, },
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "isbn"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public void addAuthor(Author author) {
        if (this.authors == null) {
            this.authors = new HashSet<>();
        }
        this.authors.add(author);
    }

}
