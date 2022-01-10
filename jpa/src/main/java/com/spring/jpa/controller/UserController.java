package com.spring.jpa.controller;

import com.spring.jpa.DO.User;
import com.spring.jpa.repository.UserRepository;
import com.spring.jpa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RestController
public class UserController {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserService userService;


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
/*
总结：如果是RuntimeException会回滚，如果是Exception错误，则不会回滚，
除非标注@Transactional(rollbackFor = Exception.class)
* */
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

    //直接调用方法，则方法上的@Transactional(rollbackFor = Exception.class)不生效
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


    //不使用事务，不回滚
    @RequestMapping("/saveTest6")
    public void saveTest6() {
        saveUser(getUser(1L));
        throw new RuntimeException("不会回滚");
    }


    @RequestMapping("/versionTest")
    public void versionTest() throws InterruptedException {

        User user = userRepository.findById(1L).get();
        log.info(user.toString());

        new Thread(() -> {
            User user1 = userRepository.findById(1L).get();
            log.info(user1.toString());
            user1.setAge(11);
            log.info(userRepository.saveAndFlush(user1).toString());
        }).start();
        user.setName("version");
        Thread.sleep(1000);
        log.info(userRepository.saveAndFlush(user).toString());

    }

    /*
     * getById()需要在事务中执行
     * 如需使用在多线程中使用@Transactional，需要调用新的bean的方法，并标记@Transactional
     * @Retryable会拦截相应报错
     * 如果数据相同，则不会更新
     * */
    @RequestMapping("/versionTest2")
    @Transactional
    @Retryable(value = ObjectOptimisticLockingFailureException.class, backoff = @Backoff(multiplier = 1.5, random = true))
    public void versionTest2() throws InterruptedException {

        User user = userRepository.getById(1L);
        log.info(user.toString());

        new Thread(() -> userService.UserTransactional()).start();

        user.setName("Transactional");
        Thread.sleep(1000);
        log.info(userRepository.saveAndFlush(user).toString());

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

    }

    @RequestMapping("/sex")
    public void find(String sex) {
        System.out.println(userRepository.findBySex(sex));
    }


}
