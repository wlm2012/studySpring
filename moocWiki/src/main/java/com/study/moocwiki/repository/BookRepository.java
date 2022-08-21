package com.study.moocwiki.repository;

import com.study.moocwiki.domain.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByNameContaining(String name);

    Page<Book> findByNameContaining(String name, Pageable pageable);

}
