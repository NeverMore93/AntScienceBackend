package com.as.backend.antscience.service;

import com.as.backend.antscience.dao.LikeDao;
import com.as.backend.antscience.dto.LikeDto;
import com.as.backend.antscience.entity.Like;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * Created by lirui on 2018/2/2.
 */
@Slf4j
@Service("likeService")
public class LikeServiceImpl implements LikeService {

    @Resource
    private LikeDao likeDao;

    @Override
    public LikeDto create(LikeDto likeDto) {
        Long articleId = likeDto.getArticleId();
        Long userId = likeDto.getUserId();
        Like like = likeDao.findByUserIdAndArticleId(userId, articleId);
        if (Objects.isNull(like)){
            return createLike(userId, articleId);
        }
        return updateLike(userId, articleId,like.isLike());
    }

    private LikeDto updateLike(Long userId, Long articleId,boolean isLike) {
        likeDao.update(userId, articleId, !isLike);
        Like like = likeDao.findByUserIdAndArticleId(userId, articleId);
        return like2LikeDto(like);
    }

    private LikeDto createLike(Long userId, Long articleId) {
        Like like = new Like();
        like.setUserId(userId);
        like.setArticleId(articleId);
        like = likeDao.saveAndFlush(like);
        return like2LikeDto(like);
    }

    private LikeDto like2LikeDto(Like like) {
        return new LikeDto(like.getId(), like.getUserId(), like.getArticleId());
    }
}
