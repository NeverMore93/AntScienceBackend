package com.as.backend.antscience.controller;

import com.as.backend.antscience.dto.ArticleDto;
import com.as.backend.antscience.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8102", maxAge = 3600)
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @PostMapping("/allArticle")
    public List<ArticleDto> getAllArticle(){
        return articleService.getAllArticles();
    }

    @PostMapping("/createArticle")
    public ArticleDto createArticle(@RequestBody @Valid ArticleDto articleDto){
        articleDto = articleService.createArticle(articleDto);
        return articleDto;
    }

    @PostMapping("/demoArticle")
    public ArticleDto demoArticle(){
        String[] label = {"demo"};
        List<String> content = new ArrayList<>();
        content.add("demo1");
        content.add("demo2");
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthorName("yuan");
        articleDto.setLabel(label);
        articleDto.setTitle("Test");
        articleDto.setContent(content);
        return articleDto;
    }

    @PostMapping("/getArticle/{ArticleId}")
    public  ArticleDto getArticle(@PathVariable Long ArticleId){
        return articleService.getArticleById(ArticleId);
    }

    @DeleteMapping("/delete/{ArticleId}")
    public void deleteArticle(@PathVariable Long ArticleId){
        articleService.deleteArticleById(ArticleId);
    }

}
