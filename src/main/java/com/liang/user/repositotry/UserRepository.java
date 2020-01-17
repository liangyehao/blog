package com.liang.user.repositotry;

import com.liang.user.domain.User;

import java.util.List;

/**
 * @author liangyehao
 * @date 2020-01-17 16:00
 * @version 1.0.0
 */
public interface UserRepository {
    /**
     * 查询所有用户
     * @return List<User>
     */
    List<User> findUserList();

    /**
     * 根据id查询单个用户
     * @param id 用户id
     * @return User
     */
    User findUser(Long id);

    /**
     * 根据id删除用户
     * @param id 用户id
     */
    void deleteUser(Long id);

    /**
     * 新增或更新用户
     * @param user 用户实体
     * @return User
     */
    User saveOrUpdateUser(User user);

}
