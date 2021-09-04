package com.spring.jpa.repository;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.jpa.DO.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.util.Streamable;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//@DataJpaTest
@SpringBootTest
public class UserRepositoryTest {

    private UserRepository userRepository;

    @Resource
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void testSaveUser() {

        List<User> users = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            UUID uuid = UUID.randomUUID();

            String name = uuid.toString().substring(0, 4);
            User user = User.builder().age(11).name(name).sex("1").state("0").build();
            users.add(user);
        }

        userRepository.saveAll(users);

    }

    @Test
    public void testStreamUser() {
        Streamable<User> ageStream = userRepository.findAll(PageRequest.of(0, 2, Sort.by("name")))
                .and(User.builder().age(11).build());
        ageStream.forEach(System.out::println);
    }


    @Test
    public void testReturn() {

        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("Streamable---------------------");
        Streamable<User> ageStream = userRepository.findAll(PageRequest.of(0, 2, Sort.by("name")))
                .and(User.builder().age(11).build());
        ageStream.forEach(System.out::println);

        System.out.println("Page---------------------");
        Page<User> page = userRepository.findAll(PageRequest.of(0, 2, Sort.by("name")));
        System.out.println(page);

        System.out.println("Slice---------------------");
        Slice<User> userSlice = userRepository.findByAge(11, PageRequest.of(0, 2, Sort.by("name")));
        System.out.println(userSlice);

        System.out.println("Slice---------------------");
        Example<User> example = Example.of(User.builder().age(11).build());
        List<User> list = userRepository.findAll(example, Sort.by("n"));
        System.out.println(list);


    }
}
