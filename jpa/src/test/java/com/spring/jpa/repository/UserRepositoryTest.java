package com.spring.jpa.repository;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.jpa.domain.entity.User;
import com.spring.jpa.domain.vo.UserOnlyNameEmailVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.util.Streamable;
import org.springframework.test.annotation.Commit;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
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

        for (int i = 0; i < 3; i++) {
            UUID uuid = UUID.randomUUID();

            String name = uuid.toString().substring(0, 4);
            User user = User.builder().age(11).name(name).sex("1").state("0").email(name + ".qq.com").build();
            users.add(user);
        }

        userRepository.saveAll(users);

    }

    @Test
    @Commit
    @Transactional
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

/*        Streamable<User> ageStream = userRepository.findAll(PageRequest.of(0, 2, Sort.by("name")))
                .and(User.builder().age(11).build());
        ageStream.forEach(System.out::println);*/

        System.out.println("Page---------------------");
        Page<User> page = userRepository.findAll(PageRequest.of(0, 2, Sort.by("name")));
        System.out.println(page.getContent());

        System.out.println("Slice---------------------");
        Slice<User> userSlice = userRepository.findByAge(11, PageRequest.of(0, 2, Sort.by("name")));
        System.out.println(userSlice.getContent());

        System.out.println("List---------------------");
        Example<User> example = Example.of(User.builder().age(11).build());
        List<User> list = userRepository.findAll(example, Sort.by("id"));
        System.out.println(list);


    }

    @Test
    public void UserOnlyNameEmailDtoTest() {
        List<UserOnlyNameEmailVo> list = userRepository.findByAge(11);
        System.out.println(list);
    }

    @Test
    public void queryByNameTest() {
        System.out.println(userRepository.queryByName("", ""));
    }

    @Test
    public void queryByUserTest() {
        System.out.println(userRepository.queryByUserNative(User.builder().name("a589").build()));
    }

    @Test
    @Commit
    @Transactional
    public void versionTest() throws InterruptedException {
        System.out.println(userRepository.findById(1L).get());
        User user = userRepository.getById(1L);
        System.out.println(user);

        new Thread(() -> {
            User user1 = userRepository.findById(1L).get();
            user1.setAge(11);
            userRepository.saveAndFlush(user1);
        }).start();
        user.setAge(26);
        Thread.sleep(1000);
        userRepository.saveAndFlush(user);
        Thread.sleep(1000);

    }

    @Test
    @Transactional
    public void LockTest() throws InterruptedException {
        User user = userRepository.findByIdLock(2L);
        log.info("129" + user.toString());
        user.setBirthday(LocalDate.now());
        log.info("131" + user);
        new Thread(() -> {
            User user1 = userRepository.findByIdLock(2L);
            log.info("134" + user1.toString());
            user1.setRegisteredTime(LocalDateTime.now());
            log.info("136" + user1);
            userRepository.saveAndFlush(user1);
            log.info("138" + user1);
        }).start();
        Thread.sleep(1000);
        log.info("141" + user);
        userRepository.saveAndFlush(user);
        log.info("143" + user);
        Thread.sleep(1000);
        log.info("145" + user);
    }


}
