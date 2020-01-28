package com.feng.springbootthumbup.entity;

import com.feng.springbootthumbup.enums.LikedStatusEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author admin
 * @create 2020-01-28-11:26
 */
@Entity
@Data
public class UserLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //被点赞的用户的id
    private String likedUserId;

    //点赞的用户的id
    private String likedPostId;

    //点赞的状态.默认未点赞

    private Integer status = LikedStatusEnum.UNLIKE.getCode();
    public UserLike() {
    }

    public UserLike(String likedUserId, String likedPostId, Integer status) {
        this.likedUserId = likedUserId;
        this.likedPostId = likedPostId;
        this.status = status;
    }

}
