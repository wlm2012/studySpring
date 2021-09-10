package com.spring.jpa.service;


import com.spring.jpa.DO.User;
import com.spring.jpa.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

}
