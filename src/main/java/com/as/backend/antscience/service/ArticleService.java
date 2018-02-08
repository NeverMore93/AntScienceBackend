package com.as.backend.antscience.service;

import com.as.backend.antscience.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    ArticleDto create(ArticleDto articleDto);
    List<ArticleDto> getArticles();
    ArticleDto getById(Long articleId);
    void deleteById(Long articleId);
    void updateLikes(Long articleId, boolean isLike);
}
