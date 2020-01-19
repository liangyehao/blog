package com.liang.user.repositotry;

import com.liang.user.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author liangyehao
 * @date 2020-01-17 16:00
 * @version 1.0.0
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
