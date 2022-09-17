package com.spring.jpa.repository;

import com.spring.jpa.domain.entity.DogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<DogEntity,String> {
}
