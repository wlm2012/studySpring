package com.spring.jpa.repository;

import com.spring.jpa.DO.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByName(String name, Pageable pageable);

    Slice<User> findByAge(long age, Pageable pageable);

    List<User> findByState(String state, Pageable pageable);

    List<User> findByState(String state, Sort sort);

    List<User> findTop3ByName(String name);

}
