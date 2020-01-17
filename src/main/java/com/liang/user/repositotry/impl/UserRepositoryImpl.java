package com.liang.user.repositotry.impl;

import com.liang.user.domain.User;
import com.liang.user.repositotry.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/1/17 21:16
 * @Content 用户资源库实现类
 */
public class UserRepositoryImpl implements UserRepository {
    //存储用户信息
    private ConcurrentHashMap<Long, User> userMap = new ConcurrentHashMap<>();

    //id自增工具类
    private static AtomicInteger count = new AtomicInteger();

    /**
     * 查询所有用户
     *
     * @return List<User>
     */
    @Override
    public List<User> findUserList() {
        return new ArrayList<>(userMap.values());
    }

    /**
     * 根据id查询单个用户
     *
     * @param id 用户id
     * @return User
     */
    @Override
    public User findUser(Long id) {
        return userMap.get(id);
    }

    /**
     * 根据id删除用户
     *
     * @param id 用户id
     */
    @Override
    public void deleteUser(Long id) {
        userMap.remove(id);
    }

    /**
     * 新增或更新用户
     *
     * @param user 用户实体
     * @return User
     */
    @Override
    public User saveOrUpdateUser(User user) {
        if (user.getId() == null) {
            int id = count.incrementAndGet();
            user.setId((long) id);
        }
        userMap.put(user.getId(), user);
        return user;
    }
}
