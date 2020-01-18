package com.liang.user.repositotry.impl;

import com.liang.user.domain.User;
import com.liang.user.repositotry.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
////由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
//@WebAppConfiguration
class UserRepositoryImplTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void init() {
        User user1 = new User("liangyehao1", "1111111111", "11@qq.com");
        User user2 = new User("liangyehao2", "2222222222", "22@qq.com");
        User user3 = new User("liangyehao3", "3333333333", "33@qq.com");
        userRepository.saveOrUpdateUser(user1);
        userRepository.saveOrUpdateUser(user2);
        userRepository.saveOrUpdateUser(user3);
    }

    @Test
    void findUserList() {
        List<User> userList = userRepository.findUserList();
        System.out.println("---------findUserList-------------");
        System.out.println(userList);
        System.out.println("---------findUserList-------------");
    }

    @Test
    void findUser() {
        User user = userRepository.findUser(1L);
        System.out.println("---------findUser-------------");
        System.out.println(user);
        System.out.println("---------findUser-------------");
    }

    @Test
    void deleteUser() {
        userRepository.deleteUser(2L);
        findUserList();
    }

    @Test
    void saveOrUpdateUser() {
        User user = userRepository.findUser(1L);
        user.setName("梁业浩");
        userRepository.saveOrUpdateUser(user);
        findUserList();
    }

}