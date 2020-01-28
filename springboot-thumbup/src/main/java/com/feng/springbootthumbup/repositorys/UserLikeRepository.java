package com.feng.springbootthumbup.repositorys;

import com.feng.springbootthumbup.entity.UserLike;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author admin
 * @create 2020-01-28-11:53
 */
public interface UserLikeRepository extends JpaRepository<UserLike, Integer> {
    Page<UserLike> findByLikedUserIdAndStatus(String likedUserId, Integer status, Pageable pageable);

    Page<UserLike> findByLikedPostIdAndStatus(String likedPostId, Integer status, Pageable pageable);

    UserLike findByLikedUserIdAndLikedPostId(String likedUserId, String likedPostId);}