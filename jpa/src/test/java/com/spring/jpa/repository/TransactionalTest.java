package com.spring.jpa.repository;

import com.spring.jpa.DO.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
public class TransactionalTest {

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

    @Test
    @Commit
    @Transactional
    public void saveTest1() throws Exception {
        User user = getUser(1);
        saveUser(user);
        throw new Exception("不会回滚");
    }

    @Test
    @Commit
    @Transactional(rollbackFor = Exception.class)
    public void saveTest2() throws Exception {
        saveTest1();
        throw new Exception("不会回滚");
    }





}
