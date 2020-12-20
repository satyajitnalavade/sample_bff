package com.example.sample_bff.repository;

import com.example.sample_bff.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {}
