package com.as.backend.antscience.service;

import com.as.backend.antscience.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    ArticleDto createArticle(ArticleDto articleDto);
    List<ArticleDto> getAllArticles();
    ArticleDto getArticleById(Long userId,Long articleId);
}
