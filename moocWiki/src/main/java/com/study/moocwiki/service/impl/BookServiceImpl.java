package com.study.moocwiki.service.impl;


import com.study.moocwiki.domain.entity.Book;
import com.study.moocwiki.repository.BookRepository;
import com.study.moocwiki.utils.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl {

    private final BookRepository bookRepository;


    public List<Book> listBook(String name) {
        return bookRepository.findByNameContaining(name);
    }


    public Page<Book> pageBook(String name) {
        PageRequest pageRequest = PageUtils.start();
        return bookRepository.findByNameContaining(name, pageRequest);
    }
}
