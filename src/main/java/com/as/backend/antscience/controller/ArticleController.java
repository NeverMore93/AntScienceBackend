package com.as.backend.antscience.controller;

import com.as.backend.antscience.dto.ArticleDto;
import com.as.backend.antscience.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8102","*"}, maxAge = 3600)
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @GetMapping("/auth/articles")
    public List<ArticleDto> articles(){
        return articleService.getArticles();
    }

    @PostMapping("/article")
    public ArticleDto create(@RequestBody @Valid ArticleDto articleDto){
        return articleService.create(articleDto);
    }

    @GetMapping("/auth/article/id/{id}")
    public  ArticleDto getById(@PathVariable Long id){
        return articleService.getById(id);
    }

    @DeleteMapping("/article/id/{id}")
    public void deleteById(@PathVariable Long id){
        articleService.deleteById(id);
    }

    @PostMapping("/articles/{authorID}")
    public List<ArticleDto>  AuthorArticles(@PathVariable Long authorID){
        return articleService.getArticlesByAuthorID(authorID);
    }

}
