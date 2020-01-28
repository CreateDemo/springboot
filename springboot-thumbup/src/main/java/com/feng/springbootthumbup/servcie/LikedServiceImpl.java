package com.feng.springbootthumbup.servcie;

import com.feng.springbootthumbup.entity.LikedCountDTO;
import com.feng.springbootthumbup.entity.UserLike;
import com.feng.springbootthumbup.enums.LikedStatusEnum;
import com.feng.springbootthumbup.repositorys.UserLikeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author admin
 * @create 2020-01-28-11:51
 */
@Service
@Slf4j
public class LikedServiceImpl implements  LikedService {
    @Autowired
    UserLikeRepository likeRepository;
    @Autowired
    RedisService redisService;
//    @Autowired
//    UserService userService;

    @Override
    public UserLike save(UserLike userLike) {
        return likeRepository.save(userLike);
    }

    @Override
    public List<UserLike> saveAll(List<UserLike> list) {
        return likeRepository.saveAll(list);
    }

    @Override
    public Page<UserLike> getLikedListByLikedUserId(String likedUserId, Pageable pageable) {
        return likeRepository.findByLikedUserIdAndStatus(likedUserId, LikedStatusEnum.LIKE.getCode(),pageable);
    }

    @Override
    public Page<UserLike> getLikedListByLikedPostId(String likedPostId, Pageable pageable) {
        return likeRepository.findByLikedPostIdAndStatus(likedPostId, LikedStatusEnum.LIKE.getCode(), pageable);
    }

    @Override
    public UserLike getByLikedUserIdAndLikedPostId(String likedUserId, String likedPostId) {
        return likeRepository.findByLikedUserIdAndLikedPostId(likedUserId, likedPostId);
    }


    @Transactional
    @Override
    public void transLikedFromRedis2DB() {
        List<UserLike> list = redisService.getLikedDataFromRedis();
        for (UserLike like : list) {
            UserLike ul = getByLikedUserIdAndLikedPostId(like.getLikedUserId(), like.getLikedPostId());
            if (ul == null){
                //没有记录，直接存入
                save(like);
            }else{
                //有记录，需要更新
                ul.setStatus(like.getStatus());
                save(ul);
            }
        }
    }

    @Override
    public void transLikedCountFromRedis2DB() {
        List<LikedCountDTO> list = redisService.getLikedCountFromRedis();
        for (LikedCountDTO dto : list) {
//            UserInfo user = userService.findById(dto.getId());
//            //点赞数量属于无关紧要的操作，出错无需抛异常
//            if (user != null){
//                Integer likeNum = user.getLikeNum() + dto.getCount();
//                user.setLikeNum(likeNum);
//                //更新点赞数量
//                userService.updateInfo(user);
//            }
        }
    }
}
