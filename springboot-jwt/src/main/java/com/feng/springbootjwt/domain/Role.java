package com.feng.springbootjwt.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author admin
 * @create 2020-01-28-19:12
 */
public class Role implements GrantedAuthority {
    private Long id;
    private String name;

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


    @Override
    public String getAuthority() {
        return name;
    }
}
