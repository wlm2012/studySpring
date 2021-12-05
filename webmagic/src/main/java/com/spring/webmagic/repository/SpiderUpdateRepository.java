package com.spring.webmagic.repository;

import com.spring.webmagic.entity.SpiderUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpiderUpdateRepository extends JpaRepository<SpiderUpdate, Long> {

    Optional<SpiderUpdate> findByName(String name);
}
