package com.liang.es.repository;

import com.liang.es.domain.Blog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogRepositoryTest {

    @Autowired
    private BlogRepository blogRepository;

    @BeforeEach
    void setUp() {
        blogRepository.deleteAll();
        blogRepository.save(new Blog("标题1", "总结1", "内容1"));
        blogRepository.save(new Blog("标2", "总结2", "内容2"));
        blogRepository.save(new Blog("题3", "总结3", "内容3"));
    }

    @Test
    void testFindAll() {
        Iterable<Blog> blogs = blogRepository.findAll();
        blogs.forEach(
                System.out::println
        );
    }
}