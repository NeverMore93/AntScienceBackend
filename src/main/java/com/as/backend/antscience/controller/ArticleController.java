package com.as.backend.antscience.controller;

import com.as.backend.antscience.dto.ArticleDto;
import com.as.backend.antscience.entity.Article;
import com.as.backend.antscience.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @PostMapping("/allArticle")
    public List<Article> getAllArticle(){
        return null;
    }

    @PostMapping("/createArticle")
    public ArticleDto createArticle(@RequestBody @Valid ArticleDto articleDto){
        articleDto = articleService.createArticle(articleDto);
        return articleDto;
    }

    @PostMapping("/demoArticle")
    public ArticleDto demoArticle(){
        String[] label = {"adasd"};
        String[] content = {"qwe","asd"};
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthorName("yuan");
        articleDto.setLabel(label);
        articleDto.setTitle("test");
        articleDto.setContent(content);
        return articleDto;
    }

    @PostMapping("/getArticle/{ArticleId}")
    public  ArticleDto getArticle(){

        return null;
    }

}
