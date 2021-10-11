package com.spring.jpa.repository;

import com.spring.jpa.DO.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("""
            select o from Order o where o.id=:id
                        """)
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Transactional
    Order findByIdLock(Long id);

    @Query("""
            select o from Order o where o.userId in (:ids)
            """)
    List<Order> findByUserIdIn1(List<Long> ids);
}
