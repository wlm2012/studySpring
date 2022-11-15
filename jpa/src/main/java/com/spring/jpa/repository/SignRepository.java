package com.spring.jpa.repository;

import com.spring.jpa.domain.entity.SignEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignRepository extends JpaRepository<SignEntity,String> {
}
