package com.example.sample_bff.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookWrapper {
    private String title;
    private String isbn;
    private LocalDate publishedDate;
}
