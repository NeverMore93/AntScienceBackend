package com.as.backend.antscience.dao;

import com.as.backend.antscience.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by lirui on 2018/2/2.
 */
@Repository
public interface LikeDao extends JpaRepository<Like, Long> {

    Like findByUserIdAndArticleId(Long userId, Long articleId);

    @Modifying
    @Query("UPDATE likes SET is_like = ?3 WHERE user_id = ?1 AND article_id = ?2 ")
    void update(Long userId, Long articleId, boolean isLike);
}
