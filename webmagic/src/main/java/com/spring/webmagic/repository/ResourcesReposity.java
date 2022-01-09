package com.spring.webmagic.repository;

import com.spring.webmagic.entity.Resources;
import com.spring.webmagic.entityEnum.ResourcesEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourcesReposity extends JpaRepository<Resources, Long> {

    List<Resources> findByType(ResourcesEnum type);
}
