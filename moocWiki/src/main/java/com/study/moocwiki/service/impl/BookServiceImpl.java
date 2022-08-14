package com.study.moocwiki.service.impl;


import com.study.moocwiki.entity.Book;
import com.study.moocwiki.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl {

    private final BookRepository bookRepository;


    public List<Book> listBook(String name) {
        return bookRepository.findByName(name);
    }
}
