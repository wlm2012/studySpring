package com.spring.jpa.controller;


import com.spring.jpa.domain.entity.Author;
import com.spring.jpa.domain.entity.Book;
import com.spring.jpa.repository.AuthorRepository;
import com.spring.jpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/book")
    public void book() {
        Optional<Book> optionalBook = bookRepository.findById(1L);
        Optional<Author> optionalAuthor = authorRepository.findById(1L);

        if (optionalBook.isPresent() && optionalAuthor.isPresent()) {
            Book book = optionalBook.get();
            Author author = optionalAuthor.get();
            book.setPrice(996.01);
            //需使用set，而不能使用list。
            // 如果使用list，且维护多条重复的关系，会将这些重复的关系全部插入数据库，set则会过滤掉重复关系
            Set<Author> authors = book.getAuthors();
            authors.add(author);

            bookRepository.save(book);
            authorRepository.save(author);
        }

    }
}
