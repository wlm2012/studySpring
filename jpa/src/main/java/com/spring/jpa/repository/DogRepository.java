package com.spring.jpa.repository;

import com.spring.jpa.DO.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog,Long> {
}
