package com.spring.webmagic.repository;

import com.spring.webmagic.entity.Path;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PathRepository extends JpaRepository<Path, Long> {

    List<Path> findByEnable(boolean enable);
}
