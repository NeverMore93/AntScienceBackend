package com.as.backend.antscience.dao;

import com.as.backend.antscience.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface ArticleDao extends JpaRepository<Article, Long> {

    Article saveAndFlush(Article article);

    List<Article> findAll();

    Article findArticleById(Long Id);

    void delete(Long aLong);

    @Modifying
    @Query("UPDATE articles SET likes = likes + ?2 WHERE article_id = ?1 ")
    void updateLikes(Long articleId, int i);

    List<Article> findArticlesByAuthorID(Long authorID);
}
