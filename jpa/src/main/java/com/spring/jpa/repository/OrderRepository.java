package com.spring.jpa.repository;

import com.spring.jpa.DO.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("""
            select o from Order o where o.id=:id
                        """)
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Transactional
    Order findByIdLock(Long id);
}
