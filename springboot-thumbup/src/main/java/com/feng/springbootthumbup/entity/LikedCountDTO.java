package com.feng.springbootthumbup.entity;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author admin
 * @create 2020-01-28-11:44
 */
@Getter
public class LikedCountDTO implements Serializable {
    private static final long serialVersionUID = -2856160546081194945L;

    private String id;

    private Integer count;

    public LikedCountDTO() {
    }

    public LikedCountDTO(String id, Integer count) {
        this.id = id;
        this.count = count;
    }
}
