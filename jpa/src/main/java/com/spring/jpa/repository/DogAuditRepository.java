package com.spring.jpa.repository;

import com.spring.jpa.domain.entity.DogAuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogAuditRepository extends JpaRepository<DogAuditEntity,String> {
}
