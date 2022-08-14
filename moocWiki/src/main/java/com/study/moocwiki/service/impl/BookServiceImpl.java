package com.study.moocwiki.service.impl;


import com.study.moocwiki.domain.entity.Book;
import com.study.moocwiki.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl {

    private final BookRepository bookRepository;


    public List<Book> listBook(String name) {
        return bookRepository.findByName(name);
    }
}
