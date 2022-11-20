package com.spring.jpa.controller;


import com.spring.jpa.domain.entity.Author;
import com.spring.jpa.domain.entity.Book;
import com.spring.jpa.repository.AuthorRepository;
import com.spring.jpa.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @GetMapping("listBooks")
    public Page<Book> listBooks() {
        return bookRepository.findAll(PageRequest.of(1, 2));
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

    @GetMapping("/findByBookName")
    public Set<Book> findByBookName(String name) {
        System.out.println("name = " + name);
        return bookRepository.findByBookName2(name);
    }
}
