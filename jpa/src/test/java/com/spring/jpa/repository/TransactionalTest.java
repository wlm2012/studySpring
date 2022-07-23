package com.spring.jpa.repository;

import com.spring.jpa.domain.entity.User;
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


    @Transactional
    public User saveUser(User user) {
        if (user.getRegisteredTime() == null) {
            user.setRegisteredTime(LocalDateTime.now());
        }
        return userRepository.save(user);
    }

    @Test
    @Commit
    @Transactional
    public void saveTest() throws Exception {
        User user = getUser(1);
        saveUser(user);
        throw new Exception("不会回滚");
    }

    @Test
    @Commit
    @Transactional(rollbackFor = Exception.class)
    public void saveTest1() throws Exception {
        saveUser(getUser(1L));
        throw new Exception("不会回滚");
    }


    @Test
    @Commit
    @Transactional()
    public void saveTest2() {
        saveUser(getUser(1L));
        throw new RuntimeException("不会回滚");
    }


}
