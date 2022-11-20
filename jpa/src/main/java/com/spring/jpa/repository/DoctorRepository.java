package com.spring.jpa.repository;

import com.spring.jpa.domain.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, String> {

    @Query("select d from DoctorEntity d where " +
            " :data is null or :data='' or d.name like CONCAT('%',:data,'%') ")
    List<DoctorEntity> like(String data);
}
