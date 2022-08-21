package com.study.moocwiki.controller;

import com.study.moocwiki.domain.entity.Book;
import com.study.moocwiki.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookServiceImpl bookService;

    @GetMapping("/list")
    public List<Book> listBook(String name) {
        return bookService.listBook(name);
    }

    @GetMapping("/pageBook")
    public Page<Book> pageBook(String name) {
        return bookService.pageBook(name);
    }


}
