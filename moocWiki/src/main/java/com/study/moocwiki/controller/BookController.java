package com.study.moocwiki.controller;

import com.study.moocwiki.entity.Book;
import com.study.moocwiki.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
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


}
