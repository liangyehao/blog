package com.liang.es.controller;

import com.liang.es.domain.Blog;
import com.liang.es.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/1/22 19:33
 * @content 博客控制器
 */
@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    @GetMapping("/findBlogs")
    public List<Blog> findBlogs(@RequestParam("title") String title,
                                @RequestParam("summary") String summary,
                                @RequestParam("content") String content
    ) {
        return blogRepository.findDistinctByTitleAndSummaryAndContent(title, summary, content);
    }
}
