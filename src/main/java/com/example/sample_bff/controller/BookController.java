package com.example.sample_bff.controller;

import com.example.sample_bff.service.GraphQLService;
import graphql.ExecutionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author satya */
@RequestMapping("/rest/books")
@RestController
public class BookController {

  private static final Logger logger = LoggerFactory.getLogger(BookController.class);
  private GraphQLService graphQLService;

  public BookController(GraphQLService graphQLService) {
    this.graphQLService = graphQLService;
  }

  @PostMapping
  public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
    logger.info("Entering getAllBooks@BookController");
    ExecutionResult execute = graphQLService.getGraphQL().execute(query);
    return new ResponseEntity<>(execute, HttpStatus.OK);
  }
}
