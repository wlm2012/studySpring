package com.spring.webmagic.repository;

import com.spring.webmagic.entity.Resources;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourcesReposity extends JpaRepository<Resources, Long> {
}
