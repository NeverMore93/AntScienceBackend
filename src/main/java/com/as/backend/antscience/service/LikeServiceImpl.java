package com.as.backend.antscience.service;

import com.as.backend.antscience.dao.LikeDao;
import com.as.backend.antscience.dto.LikeDto;
import com.as.backend.antscience.entity.Like;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lirui on 2018/2/2.
 */
@Slf4j
@Service("likeService")
public class LikeServiceImpl implements LikeService {

    @Resource
    private LikeDao likeDao;

    @Override
    public Like create(LikeDto likeDto) {
        Long articleId = likeDto.getArticleId();
        Long userId = likeDto.getUserId();
        Like like = likeDao.findByUserIdAndArticleId(userId, articleId);
        return null;
    }


}
