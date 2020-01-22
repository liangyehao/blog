package com.liang.es.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/1/22 16:01
 * @content 博客实体
 */
@Document(indexName = "blog", type = "blog")
public class Blog {
    @Id
    private String id;
    private String title;
    private String summary;
    private String content;

    protected Blog() {
    }

    public Blog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
