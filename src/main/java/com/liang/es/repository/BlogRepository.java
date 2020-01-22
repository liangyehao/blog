package com.liang.es.repository;

import com.liang.es.domain.Blog;
import org.springframework.data.repository.CrudRepository;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/1/22 16:05
 * @content 博客资源库
 */
public interface BlogRepository extends CrudRepository<Blog, String> {
}
