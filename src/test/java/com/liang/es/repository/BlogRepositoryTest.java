package com.liang.es.repository;

import com.liang.es.domain.Blog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogRepositoryTest {

    @Autowired
    private BlogRepository blogRepository;

    @BeforeEach
    void setUp() {
        blogRepository.deleteAll();
        blogRepository.save(new Blog("标题1", "总结1", "内容1"));
        blogRepository.save(new Blog("标2", "嘻嘻总结2", "内容2"));
        blogRepository.save(new Blog("题3", "总结3", "嘻嘻内容3"));
    }

    @Test
    void testFindAll() {
        Iterable<Blog> blogs = blogRepository.findAll();
        blogs.forEach(
                System.out::println
        );
    }

    @Test
    void findBlogsByTitle() {
        String title = "标";
        String summary = "结";
        String content = "内容";
        List<Blog> blogs = blogRepository.findDistinctByTitleAndSummaryAndContent(title, summary, content);
        blogs.forEach(System.out::println);
    }
}