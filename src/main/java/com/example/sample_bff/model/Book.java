package com.example.sample_bff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** @author satya */
@Data
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

  @Id private String isn;
  private String title;
  private String publisher;
  private String publishedDate;
  private String[] author;
}
