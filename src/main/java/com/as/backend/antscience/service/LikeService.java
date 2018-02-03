package com.as.backend.antscience.service;

import com.as.backend.antscience.dto.LikeDto;
import com.as.backend.antscience.entity.Like;

/**
 * Created by lirui on 2018/2/2.
 */
public interface LikeService {
    Like create(LikeDto likeDto);
}
