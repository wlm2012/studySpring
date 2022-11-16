package com.spring.jpa.service.impl;


import com.spring.jpa.domain.entity.User;
import com.spring.jpa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public void TestUser() {

        List<User> byState = userRepository.findByState("1", PageRequest.of(0, 2, Sort.by("age")));
        byState.forEach(System.out::println);


        Streamable<User> userStreamable = userRepository.findAll(PageRequest.of(0, 3, Sort.by("bb")))
                .and(User.builder().age(11).build());

        userStreamable.forEach(System.out::println);

    }

    @Transactional
    public void UserTransactional() {
        User user1 = userRepository.getById("1");
        log.info(user1.toString());
        user1.setAge(11);
        log.info(userRepository.save(user1).toString());
    }


}
