package com.spring.jpa.repository;

import com.spring.jpa.DO.User;
import com.spring.jpa.DO.UserOnlyNameEmailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByName(String name, Pageable pageable);

    Slice<User> findByAge(int age, Pageable pageable);

    List<User> findByState(String state, Pageable pageable);

    List<User> findByState(String state, Sort sort);

    List<User> findTop3ByName(String name);

    List<UserOnlyNameEmailDto> findByAge(int age);

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Transactional
    @Query(value = """
            select u from User u where u.id=:id""")
    User findByIdLock(Long id);

    @Query(value = "select * from t_user u where u.id=:id for update", nativeQuery = true)
    User findByIdLock2(Long id);

    @Query(value = """ 
            select u from User u where (:name is null or :name='' or u.name=:name)
            and (:email is null or :email ='' or u.email=:email)""")
    List<User> queryByName(String name, String email);


    @Query(value = """
            select u.name as name,u.email as email from t_user u
            where (:#{#user.name} is null or u.name =:#{#user.name})
            and (:#{#user.email} is null or u.email =:#{#user.email})"""
            , nativeQuery = true)
    List<User> queryByUserNative(User user);


    List<User> findBySex(String sex);

}
