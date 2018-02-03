package com.as.backend.antscience.dao;

import com.as.backend.antscience.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lirui on 2018/2/2.
 */
@Repository
public interface LikeDao extends JpaRepository<Like, Long> {
    Like findByUserIdAndArticleId(Long userId, Long articleId);
}
