package com.study.moocwiki.repository;

import com.study.moocwiki.domain.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByNameContaining(String name);

    Page<BookEntity> findByNameContaining(String name, Pageable pageable);

}
