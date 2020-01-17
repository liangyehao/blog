package com.liang.user.domain;

/**
 * @author liangyehao
 * @date 2020-01-17 16:30
 * @version 1.0.0
 */
public class User {
    private Long id;
    private String name;
    private String password;
    private String emial;

    public User() {
    }

    public User(String name, String password, String emial) {
        this.name = name;
        this.password = password;
        this.emial = emial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", emial='" + emial + '\'' +
                '}';
    }
}
