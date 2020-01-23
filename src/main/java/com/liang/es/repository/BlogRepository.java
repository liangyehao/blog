package com.liang.es.repository;

import com.liang.es.domain.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/1/22 16:05
 * @content 博客资源库
 */
public interface BlogRepository extends CrudRepository<Blog, String> {
    /**
     * 根据标题、摘要和内容查询相关博客
     *
     * @param title   标题
     * @param summary 摘要
     * @param content 内容
     * @return 博客集合
     */
    List<Blog> findDistinctByTitleAndSummaryAndContent(String title, String summary, String content);
}
