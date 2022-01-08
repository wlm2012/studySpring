package com.spring.webmagic.repository;

import com.spring.webmagic.entity.AVstar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AVstarRepository extends JpaRepository<AVstar, Long> {


}
