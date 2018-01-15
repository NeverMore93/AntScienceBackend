package com.as.backend.antscience.dao;

import com.as.backend.antscience.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface ArticleDao extends JpaRepository<Article,Long> {
    Article saveAndFlush(Article article);
    List<Article> findAll();
}
