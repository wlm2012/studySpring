package com.spring.jpa.controller;

import com.spring.jpa.DO.User;
import com.spring.jpa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@RestController
public class UserController {

    @Resource
    private UserRepository userRepository;


    public User getUser(long id) {
        return userRepository.findById(id).get();
    }


    public User saveUser(User user) {
        if (user.getRegisteredTime() == null) {
            user.setRegisteredTime(LocalDateTime.now());
        }
        return userRepository.save(user);
    }


    @Transactional
    @RequestMapping("/saveTest")
    public void saveTest() throws Exception {
        User user = getUser(1);
        saveUser(user);
        throw new Exception("不会回滚");
    }


    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/saveTest1")
    public void saveTest1() throws Exception {
        saveUser(getUser(1L));
        throw new Exception("会回滚");
    }

    @Transactional()
    @RequestMapping("/saveTest2")
    public void saveTest2() {
        saveUser(getUser(1L));
        throw new RuntimeException("会回滚");
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/saveTest3")
    public void saveTest3() {
        saveUser(getUser(1L));
    }

    @Transactional
    @RequestMapping("/saveTest4")
    public void saveTest4() throws Exception {
        saveTest3();
        throw new Exception("不会回滚");
    }


    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/saveTest5")
    public void saveTest5() {
        saveUser(getUser(1L));
        throw new RuntimeException("会回滚");
    }


    @RequestMapping("/saveTest6")
    public void saveTest6() {
        saveUser(getUser(1L));
        throw new RuntimeException("不会回滚");
    }


    @RequestMapping("/versionTest")
    @Transactional
    public void versionTest() throws InterruptedException {

        User user = userRepository.getById(1L);
        log.info(user.toString());

        new Thread(() -> {
            User user1 = userRepository.getById(1L);
            log.info(user1.toString());
            user1.setAge(11);
            log.info(userRepository.saveAndFlush(user1).toString());
        }).start();
        user.setAge(26);
        Thread.sleep(1000);
        log.info(userRepository.saveAndFlush(user).toString());
        Thread.sleep(1000);

    }

    @RequestMapping("/LockTest")
    @Transactional
    public void LockTest() throws InterruptedException {
        User user = userRepository.findByIdLock(2L);
        user.setBirthday(LocalDate.now());

        new Thread(() -> {
            User user1 = userRepository.findByIdLock(2L);
            user1.setRegisteredTime(LocalDateTime.now());
            userRepository.saveAndFlush(user1);

        }).start();
        Thread.sleep(1000);
        userRepository.saveAndFlush(user);
        Thread.sleep(1000);

    }

}
