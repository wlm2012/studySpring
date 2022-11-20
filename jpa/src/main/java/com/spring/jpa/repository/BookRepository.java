package com.spring.jpa.repository;

import com.spring.jpa.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("""
            select b from Book b where (:name is null or :name='' or b.name like %:name%)
                        """)
    Set<Book> findByBookName(String name);

    /**
     * 应使用concat的方式，如果直接 %:name%，则参数为null时，会生成代理对象，导致查不到结果
     */
    @Query("""
            select b from Book b where (:name is null or :name='' or b.name like concat('%',:name,'%') )
                        """)
    Set<Book> findByBookName1(String name);

}
